package com.neyas.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neyas.microservice.entity.Department;
import com.neyas.microservice.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
  
  @Autowired
  private DepartmentRepository departmentRepository;

  public Department saveDepartment(Department d) {
    log.info("Inside the save department of department service");
    return departmentRepository.save(d);
  }

  public Optional<Department> findDepartmentById(Long departmentId) {
    log.info("Inside the find department of department service");
    return departmentRepository.findByDepartmentId(departmentId);
  }
}
