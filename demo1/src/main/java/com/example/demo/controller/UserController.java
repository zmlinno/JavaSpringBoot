package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//来指定get/post类型
@RequestMapping("/user")
@RestController
public class UserController
{
    //@RequestMapping(value = "/getRequest",method = RequestMethod.POST)
    @RequestMapping("sayHI")
    public String sayHI()
    {
        return "get request";
    }
}

