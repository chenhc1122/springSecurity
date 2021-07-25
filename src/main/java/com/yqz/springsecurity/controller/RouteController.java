package com.yqz.springsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {


    @RequestMapping({"/","/index","/index.html"})
    public String index(){
        System.out.println("-----in index-----------");
        return "index";
    }



    @RequestMapping("/login")
    public String login(){
        System.out.println("----------login---------");
        return "signup";
    }



    @RequestMapping("/admin/{name}")
    public String admin(@PathVariable("name") String name){
        System.out.println("---------------admin-------------");
        return "/admin/"+name ;
    }


    @RequestMapping("/user/{name}")
    public String user(@PathVariable("name") String name){
        System.out.println("---------------user-------------");
        return "/user/"+name ;
    }
}
