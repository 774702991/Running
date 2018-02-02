package com.qf.controller;

import com.qf.pojo.ReaList;
import com.qf.pojo.Video;
import com.qf.service.RestService;
import com.qf.service.VideoService;
import com.qf.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController {

    @Autowired
    private RestService restService;

    @Autowired
    private VideoService videoService;

    @RequestMapping("/api/rest/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        List<Video> list = videoService.getVideo();
        //map1.put("",null);
        map1.put("reaList",restService.getRest());
        map1.put("reaVideo",list.get(list.size()-1));
        map1.put("video",list);
        map.put("ret",true);
        map.put("data",map1);
        return map;
    }

    @RequestMapping("/api/rest/new")
    @ResponseBody
    public Map<String,Object> get(Integer id){
        if (id!=null){
            Map<String,Object> map = new HashMap<>();
            Map<String,Object> map1 = new HashMap<>();
            ReaList reaList = restService.getRestById(id);
            map1.put("reaList",reaList);
            map.put("ret",true);
            map.put("data",map1);
            return map;
        }
        return JsonUtil.getError("请选择新闻");
    }
}
