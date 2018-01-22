package com.jxust.demo.controller;

import com.jxust.demo.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller

public class HelloController {

//    @Autowired
//    PersonProperties personProperties;
//    @RequestMapping(value = "/hell1")
//    public String hello(){
//
//        return personProperties.getAge()+personProperties.getName()+"nihao";
//    }


    /**
     * 本地访问内容地址 ：http://localhost:8080/lmycc/hello
     * @param map
     * @return
     */
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面a");
        return "/index";
    }
    @GetMapping("/laotang")
    //@ResponseBody
    public String laoTang(){
        return "laotang";
    }
    @GetMapping("/songxianchun")
    //@ResponseBody
    public String bchun(){
        return "bchun";
    }

    @GetMapping("/yangliu")
    public String hello2(HashMap map){
        map.put("hello","干啥呢");
        return "yangliu";
    }
    @GetMapping("/dameng")
    public String hello3(HashMap map){
        map.put("hello","喵喵!");
        return "dameng";
    }
    @GetMapping("/aliyunquan")
    public String aliyunquan(HashMap map){
        //map.put("hello","干啥呢");
        return "freemarker";
    }





}
