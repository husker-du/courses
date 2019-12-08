package com.autentia.courses;

import com.autentia.courses.persistence.mapper.TeacherMapper;
import com.autentia.courses.persistence.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class CoursesApplication implements ApplicationRunner {

	CourseService courseService;

	TeacherMapper teacherMapper;

	@Autowired
	public CoursesApplication(TeacherMapper teacherMapper,
							  CourseService courseService) {
		this.teacherMapper = teacherMapper;
		this.courseService =  courseService;
	}

	public static void main(String[] args) {

		SpringApplication.run(CoursesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Intentionally left empty
	}
}
