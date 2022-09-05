package com.ltp.gradesubmission.service;


import com.ltp.gradesubmission.entity.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
}