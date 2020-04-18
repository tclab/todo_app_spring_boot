package com.tclab.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

// to allowd cross calls we use CrossOrigin annotation
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {


  // URI -> /hello-world
  // method that return "Hello World"
  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello world heroku deploy test");
  }

  /*
    To declare a path variable we use {<<variable>>}
    Then we make the method receives a parameter with the same  variable name
    and annotate this parameter with @PathVariable
   */
  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello world %s", name));
//    throw new RuntimeException("Something went wrong");
  }

}
