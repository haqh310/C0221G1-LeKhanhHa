package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ListDictionary {
    Map<String, String> map;
    {
       map = new HashMap<>();
        map.put("hello","xin chao");
        map.put("pen","but");
        map.put("table","ban");
        map.put("bye","tam biet");
    }

    public  String find(String name){
       String result = this.map.get(name);
       if(result== null){
           result = "Khong co tu nay";
       }
       return result;
    }
}
