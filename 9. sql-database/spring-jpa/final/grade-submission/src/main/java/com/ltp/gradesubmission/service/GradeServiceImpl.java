package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import java.util.Optional;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {
    
    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
         Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
         if (grade.isPresent()) {
            return grade.get();
         } else {
            throw new GradeNotFoundException(studentId, courseId);
         }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            Grade unwrappedGrade = grade.get();
            unwrappedGrade.setScore(score);
            return gradeRepository.save(unwrappedGrade);
         } else {
            throw new GradeNotFoundException(studentId, courseId);
         }
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
