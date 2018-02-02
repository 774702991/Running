<%--
  Created by IntelliJ IDEA.
  User: ZXH
  Date: 2018/1/29
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>奔跑后台登录页面</title>
     <meta name="viewport" content="width=device-width">
    <link href="login/css/base.css" rel="stylesheet" type="text/css">
    <link href="login/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="login">
    <form action="/admin/login" method="post" id="form">
        <div class="logo"></div>
        <div class="login_form">
            <div class="user">
                <input class="text_value" placeholder="请输入用户名"  name="username" type="text" id="username">
                <input class="text_value" placeholder="请输入密码" name="password" type="password" id="password">
            </div>
            <button class="button" id="submit" type="submit">登录</button>
        </div>

        <div id="tip"></div>
    </form>
</div>
<script>var basedir='login/ui/';</script>
<script src="login/ui/do.js"></script>
<script src="login/ui/config.js"></script>
<script>
    Do.ready('form', function() {
        $("#form").Validform({
            ajaxPost:true,
            postonce:true,
            tiptype:function(msg,o,cssctl){
                if(!o.obj.is("form")){
                    var objtip=o.obj.siblings(".Validform_checktip");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                }else{
                    var objtip=o.obj.find("#tip");
                    cssctl(objtip,o.type);
                    if(o.type==2){
                        window.location.href='index.php?r=admin/index/index';
                    }else{
                        objtip.text(msg);
                    }
                }
            }
        });
    });
</script>
</body>
</html>

