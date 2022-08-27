package com.ltp.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Course;


public interface CourseRepository extends CrudRepository<Course, Long> {

}