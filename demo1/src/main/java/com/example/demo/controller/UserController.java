package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController
{
    @RequestMapping("/sayHI")
    public String sayHI()
    {
        return "中国万岁 한국 만세";
    }
}
