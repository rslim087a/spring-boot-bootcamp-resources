package com.ltp.demo.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.demo.pojo.Grade;

@RestController
@CrossOrigin(origins = "*") //Not to worry. These annotations will be covered in Module 2.
public class GradeController {
    
    List<Grade> list = Arrays.asList(
        new Grade("Harry", "Potions", "C-"),
        new Grade("Hermione", "Arithmancy", "A+"),
        new Grade("Neville", "Charms", "A-")
        );

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getGrades() {
        return new ResponseEntity<List<Grade>>(list, HttpStatus.OK);
    }
}
