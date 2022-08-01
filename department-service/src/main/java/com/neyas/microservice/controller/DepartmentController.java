package com.neyas.microservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neyas.microservice.entity.Department;
import com.neyas.microservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
  
  @Autowired
  private DepartmentService departmentService;

  @PostMapping("/")
  public Department saveDepartment(@RequestBody Department d) {
    log.info("Inside the save department method of department controller");
    return departmentService.saveDepartment(d);
  }

  @GetMapping("/{id}")
  public Optional<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
    log.info("Inside the find department method of department controller");
    return departmentService.findDepartmentById(departmentId);
  }
}
