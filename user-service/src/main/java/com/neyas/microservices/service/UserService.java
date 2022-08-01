package com.neyas.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neyas.microservices.entity.User;
import com.neyas.microservices.repository.UserRepository;
import com.neyas.microservices.vo.Department;
import com.neyas.microservices.vo.ResponseTemplateVO;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
    ResponseTemplateVO vo = new ResponseTemplateVO();

    User user = userRepository.findByUserId(userId);
    vo.setUser(user);

    Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
        Department.class);

    vo.setDepartment(department);
    return vo;
  }

}
