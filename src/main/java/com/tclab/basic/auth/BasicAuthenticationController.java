package com.tclab.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// to allowd cross calls we use CrossOrigin annotation
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

  @GetMapping(path = "/basicauth")
  public AuthenticationBean helloWorldBean() {
    return new AuthenticationBean("You are authenticated");
  }



}
