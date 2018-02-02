package com.qf.controller;

import com.qf.exception.GlobalExceptions;
import com.qf.pojo.User;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.service.UserService;
import com.qf.util.JsonUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserLoginController {

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
    private static Integer CODE = 0;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    //登录
    @RequestMapping("/api/user/login_user")
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user) throws GlobalExceptions {
        System.out.println(user.toString());
        if (user.getPassword()==null&&user.getCode()==null){
            return JsonUtil.getError("请输入验证码或密码");
        }
        if (user.getPassword()==null){
            User flag =  userService.getUserById(user);
            if (flag!=null){
                if (CODE.intValue()==user.getCode().intValue()){
                    return JsonUtil.getSuccess("登录成功",flag.getId());
                }else {
                    return JsonUtil.getError("请输入正确的验证码");
                }
            }else {
                return JsonUtil.getError("请先进行注册");
            }
        }
        if (user.getCode()==null){
            User flag =  userService.getUserById(user);
            if (flag!=null){
                if(flag.getPassword().equals(user.getPassword())){
                    return JsonUtil.getSuccess("登录成功",flag.getId());
                }else{
                    return JsonUtil.getError("请输入正确的密码或使用验证码登录");
                }
            }else{
                return JsonUtil.getError("请先进行注册");
            }
        }
        return JsonUtil.getError("请输入正确的信息");
    }

    //注册
    @RequestMapping("/api/user/reg")
    @ResponseBody
    public Map<String,Object> reg(@RequestBody User user) throws GlobalExceptions{
        System.out.println(user.getCode());
        System.out.println(CODE);
        if (user.getCode()!=null){
            if (user.getCode().intValue() == CODE.intValue() ){
                User flag =  userService.getUserById(user);
                if (flag != null){
                    return JsonUtil.getError("用户已注册");
                }else{
                    //插入操作
                    userService.addUser(user);
                    //对用户信息进行初始化
                    User userSetInfo =  userService.getUserById(user);
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUser(userSetInfo);
                    userInfoService.addUserInfo(userInfo);
                    return JsonUtil.getSuccess("注册成功",null);
                }
            }
            return JsonUtil.getError("请输入正确验证码");
        }
        return JsonUtil.getError("请填写信息");
    }

    //获取验证码
    @RequestMapping("/api/user/code")
    @ResponseBody
    public Map<String,Object> Code(String username) throws GlobalExceptions{
        Map<String,Object> map = new HashMap<>();
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int mobile_code = (int)((Math.random()*9+1)*100000);

        CODE = mobile_code;

        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C41219719"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "f417e14c59cad6ce2a7f47f04982126e"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", username),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }
            map.put("ret",true);
            map.put("code",mobile_code);
            return map;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        map.put("ret",false);
        return map;
    }
}
