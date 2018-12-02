package com.bdqn.springboot_web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * @author 贺威
 * @create 2018-11-28 11:44
 */
@Controller
public class HelloContorller {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello word";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {

        map.put("hello", "你好");

        return "success";
    }
}
