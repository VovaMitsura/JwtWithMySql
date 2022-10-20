package com.example.jwtwithmysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordlController {

  @RequestMapping("/hello")
  public String firstPage(){
    return "hello world";
  }
}
