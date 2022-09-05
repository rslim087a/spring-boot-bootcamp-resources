package com.ltp.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}