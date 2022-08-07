package com.ltp.gradesubmission.utils;

import java.util.Optional;

import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.StudentNotFoundException;

public class Utility {
    
    private static final String COURSE_TYPE = "Course";
    private static final String STUDENT_TYPE = "Student";

    public static <T> T unwrapEntity(Optional<T> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else {
            switch (entity.getClass().getSimpleName()) {
                case COURSE_TYPE: throw new CourseNotFoundException(id);
                case STUDENT_TYPE: throw new StudentNotFoundException(id);
                default: throw new IllegalArgumentException("Please fix your code. You can only pass Course or Student types.");
            }
        }
    }
}
