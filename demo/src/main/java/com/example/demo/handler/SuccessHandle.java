package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

public class SuccessHandle {

    public static Map<String,Object> success(Object object){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",true);
        modelMap.put("body",object);
        return modelMap;
    }
}
