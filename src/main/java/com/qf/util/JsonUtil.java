package com.qf.util;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static Map<String,Object> getSuccess(String message,Object o){
        Map<String,Object> map = new HashMap<>();
        map.put("other",o);
        map.put("message",message);
        map.put("success",true);
        return map;
    }

    public static Map<String,Object> getError(String message){
        Map<String,Object> map = new HashMap<>();
        map.put("error",false);
        map.put("message",message);
        return map;
    }
}
