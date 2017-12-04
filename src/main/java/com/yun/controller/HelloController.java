package com.yun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/info")
    public Map<String, String> getInfo(@RequestParam String name){
        Map<String, String> map = new HashMap<>();
        return map;
    }

}
