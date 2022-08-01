package com.neyas.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
  
  @GetMapping("/userFallback")
  public String userFallback() {
    return "User Service is not available";
  }

  @GetMapping("/departmentFallback")
  public String departmentFallback() {
    return "Department Service is not available";
  }

}
