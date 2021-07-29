package com.yeb.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello"; }
    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello"; }
}