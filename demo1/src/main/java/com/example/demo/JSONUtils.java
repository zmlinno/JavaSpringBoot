package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils
{
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException
    {
        Person person = new Person();
        person.setId(5);
        person.setName("zhangsan");
        person.setPassword("123456");

        //对象转为JSON字符串
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println("JSON字符串为:"+jsonStr);

        //JSON字符串转为对象
        Person p = objectMapper.readValue(jsonStr,Person.class);

        System.out.println("转换的对象 id:"+ p.getId()+ ",name:"+p.getName()+",password:"+ p.getPassword());
    }


}
