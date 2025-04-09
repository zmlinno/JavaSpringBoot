package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.invoke.MutableCallSite;
import java.util.Arrays;
import java.util.List;
//import javax.servlet.http.HttpServletRequest;

import jakarta.servlet.http.Cookie;
import java.io.File;

@RestController
@RequestMapping("/param")
public class ParamController {


    @RequestMapping("/m1")

    public String method1(String name) {
        return "接收到参数name: " + name;
    }

    @RequestMapping("/m1/int")
    public Object method1GetInt(int age) {
        return "接收到参数age:" + age;
    }

    @RequestMapping("/m2")
    public Object method2(String name, String password) {
        return "接收到参数name: " + name + ",password:" + password;
    }

    @RequestMapping("/m3")
    public Object method3(Person p) {
        return p.toString();
    }


    //这个RequestParam前端参数key和后端接收到key可以不一致
    //比如说前端传递了一个time给后端，后端使用createtime字段来接收，这样就会出现参数接收不到的情况
    //出现这种情况的话，RequestParam来重命名前后端端参数值
//    @RequestMapping("/m4")
//    public Object method_4(@RequestParam("time") String createtime)
//    {
//        return "接收到参数createtime:"+createtime;
//    }

      //2.4上面和下面是后端参数重命名代码
      //1.非必传参数设置
      @RequestMapping("/m4")
    public Object method4(@RequestParam(value = "time",required = false)String createtime)
      {
          return "接收到参数createtime:" + createtime;
      }



      //2.4.5传递数组
      @RequestMapping("/m5")
    public Object method5(String[] arrayParam)
      {
          return Arrays.toString(arrayParam);
      }


      //2.4.6传递集合
    @RequestMapping("/m6")
    public Object method6(@RequestParam List<String> listParam)
    {
        return "size:"+listParam.size() + ",listParam:"+listParam;
    }


    //2.4.7 传递JSON数据
    //接收JSON对象需要使用 @ReqiestBody注解
    @RequestMapping(value = "/m7")
    public Object method7(@RequestBody Person person)
    {
        return person.toString();
    }


    //2.4.8获取URL中参数@PathVariable
    //和字面表达的意思一样，这个注解主要作用在URL路径上的数据绑定
    @RequestMapping("/m8/{id}/{name}")
    public String method8(@PathVariable Integer id,@PathVariable("name")String userName)
    {
        return "解析参数id:" + id + ",name:" + userName;
    }


    //2.4.9上传文件@RequestPart
    @RequestMapping("/m9")
    public String getfile(@RequestPart("file")MultipartFile file) throws IOException
    {
        //获取文件名称
        String fileName = file.getOriginalFilename();

        //文件上传到指定路径
        file.transferTo(new File("/Users/zhangmulin/Desktop/temp" + file.getOriginalFilename()));
        return "接收到文件名为: "+fileName;
    }

    //2.4.10获取Cookie/Session
    //获取Cookie
    @RequestMapping("/m10")
    public String method10(HttpServletRequest request, HttpServletResponse response)
    {
        //获取所有cookie信息
        Cookie[] cookies = request.getCookies();

        //打印cookie信息
        StringBuilder builder = new StringBuilder();
        if(cookies != null)
        {
            for(Cookie ck:cookies)
            {
                builder.append(ck.getName() + ":" + ck.getValue());
            }
        }
        return "Cookie信息:" + builder;
    }




}