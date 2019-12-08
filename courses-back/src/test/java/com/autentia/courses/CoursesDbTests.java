package com.autentia.courses;

import com.autentia.courses.persistence.mapper.CourseMapper;
import com.autentia.courses.persistence.mapper.CustomMapper;
import com.autentia.courses.persistence.mapper.TeacherDynamicSqlSupport;
import com.autentia.courses.persistence.mapper.TeacherMapper;
import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.model.Teacher;
import com.autentia.courses.persistence.service.CourseService;
import com.autentia.courses.persistence.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import static com.autentia.courses.persistence.mapper.CourseDynamicSqlSupport.*;
import static com.autentia.courses.persistence.mapper.TeacherDynamicSqlSupport.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@SpringBootTest
class CoursesDbTests {

	private TeacherMapper teacherMapper;

	private CustomMapper customMapper;

	private CourseService courseService;

	private TeacherService teacherService;

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	public CoursesDbTests(TeacherMapper teacherMapper,
						  CustomMapper customMapper,
						  CourseService courseService,
						  TeacherService teacherService) {
		this.teacherMapper = teacherMapper;
		this.customMapper = customMapper;
		this.courseService = courseService;
		this.teacherService = teacherService;
	}

	@Test
	void contextLoads() {

		assert(true);
	}

	@Test
	void numTeachersShouldBeFive() {
		assertEquals(teacherService.getAllTeachers().size(), 5);
	}

	@Test
	void numTeachersAge30ShouldBeTwo() {
		assertEquals(teacherMapper.count(
				c -> c.where(TeacherDynamicSqlSupport.age,  isEqualTo(30))), 2);
	}

	@Test
	void firstNameShouldBeAlejandra() {
		SelectStatementProvider selectStatement = select(teacher.id, firstName, lastName, age)
				.from(teacher)
				.where(lastName, isEqualTo("Mateos"))
				.build()
				.render(RenderingStrategies.MYBATIS3);
		Optional<Teacher> optTeacher = teacherMapper.selectOne(selectStatement);

		assertTrue(optTeacher.isPresent());
		assertEquals(optTeacher.get().getFirstName(), "Alejandra");
	}

	@Test
	void enumFieldsShouldBeThree() {

		assertEquals(courseService.getCourseLevels().size(), 3);
	}

	@Test
	void numCoursesShouldBeFour() {

		assertEquals(courseService.getAllCourses().size(), 4);
	}

	@Test
	void numActiveCoursesShouldBeThree() {
		List<CourseData> courses = courseService.getActiveCourseData();
		assertEquals(courseService.getActiveCourseData().size(), 3);
	}

	@Test
	void teacherOfAngular2ShouldBeRubenAguilera() throws UnsupportedEncodingException {
		List<CourseData> courseList = courseService.getAllCourseData();
		Optional<CourseData> optCourse = courseList.stream()
				.filter(course -> course.getTitle().equals("Angular 2"))
				.findAny();
		assertTrue(optCourse.isPresent());
		//String name = new String(optCourse.get().getTeacher().getBytes("ISO-8859-15"), "UTF-8");
		assertEquals(optCourse.get().getTeacher(),"Rubén Aguilera");
	}

	@Test
	void davidGomezShouldHaveIdThree() {
		assertEquals(customMapper.findTeacherIdByName("David Gómez"), 3);
	}

	@Test
	@Transactional
	void insertCourseShouldCountFive() {
		CourseData courseData = new CourseData(null, "C-Sharp for Dummies",
				"Intermedio", 30, (byte)0, null, "Alejandra Mateos");
		assertEquals(courseService.insertCourse(courseData), 1);
		assertEquals(courseMapper.select(SelectDSLCompleter.allRows()).size(), 5);
	}

	@Test
	void testJoin() {
		SelectStatementProvider selectStatement = select(course.id, title, level, hours, active, firstName, lastName)
				.from(course)
				.join(teacher)
				.on(course.idTeacher, equalTo(teacher.id))
				.build()
				.render(RenderingStrategies.MYBATIS3);
		List<Course> courseList = courseMapper.selectMany(selectStatement);
	}
}
