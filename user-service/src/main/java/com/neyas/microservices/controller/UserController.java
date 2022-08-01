package com.neyas.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neyas.microservices.entity.User;
import com.neyas.microservices.service.UserService;
import com.neyas.microservices.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    log.info("Inside save user of usercontroller");
    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
    log.info("Inside the getuserwith department of user controller");
    return userService.getUserWithDepartment(userId);
  }
}
