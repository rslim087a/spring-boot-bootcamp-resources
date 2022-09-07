package com.ltp.gradesubmission.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

    @PostMapping("/register")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
