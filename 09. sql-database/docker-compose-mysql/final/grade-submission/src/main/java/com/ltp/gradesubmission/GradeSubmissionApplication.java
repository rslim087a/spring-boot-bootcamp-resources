package com.ltp.gradesubmission;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
            new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
            new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
            new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
            new Student("Neville Longbottom", LocalDate.parse(("1980-07-30"))) 
        };
		
		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}
		
	}

}
