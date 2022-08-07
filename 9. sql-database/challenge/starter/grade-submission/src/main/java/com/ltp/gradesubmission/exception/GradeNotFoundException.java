package com.ltp.gradesubmission.exception;

public class GradeNotFoundException extends RuntimeException { 

    public GradeNotFoundException(Long studentId, Long courseId) {
        super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' does not exist in our records");
    }
    
}