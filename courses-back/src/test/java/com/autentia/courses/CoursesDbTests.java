package com.autentia.courses;

import com.autentia.courses.persistence.dao.CourseMapper;
import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.model.Teacher;
import com.autentia.courses.persistence.service.CourseService;
import com.autentia.courses.persistence.service.CustomService;
import com.autentia.courses.persistence.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.autentia.courses.persistence.dao.CourseDynamicSqlSupport.*;
import static com.autentia.courses.persistence.dao.TeacherDynamicSqlSupport.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@SpringBootTest
@ActiveProfiles("test")
class CoursesDbTests {

	private CourseService courseService;

	private TeacherService teacherService;

	private CustomService customService;

	private CourseMapper courseMapper;

	@Autowired
	public CoursesDbTests(CourseService courseService,
						  TeacherService teacherService,
						  CustomService customService,
						  CourseMapper courseMapper) {
		this.courseService = courseService;
		this.teacherService = teacherService;
		this.customService = customService;
		this.courseMapper = courseMapper;
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
		// given
		Integer age = 30;

		// when
		Long numTeachers = teacherService.numTeachersByAge(age);

		// then
		assertEquals(2, numTeachers);
	}

	@Test
	void enumFieldsShouldBeThree() throws SQLException, ClassNotFoundException {
		assertEquals(customService.getCourseLevels().size(), 3);
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
		assertNotNull(optCourse.get().getTeacher());
		assertEquals(optCourse.get().getTeacher().getFirstName(), "Rubén");
		assertEquals(optCourse.get().getTeacher().getLastName(), "Aguilera");
	}

	@Test
	@Transactional
	void insertCourseShouldCountFive() {
		// given
		CourseData courseData = mock(CourseData.class);
		Teacher teacher = mock(Teacher.class);
		when(teacher.getFirstName()).thenReturn("Alejandra");
		when(teacher.getLastName()).thenReturn("Mateos");
		when(courseData.getTitle()).thenReturn("C-Sharp for Dummies 2");
		when(courseData.getLevel()).thenReturn("Intermedio");
		when(courseData.getHours()).thenReturn(30);
		when(courseData.getActive()).thenReturn((byte)0);
		when(courseData.getTeacher()).thenReturn(teacher);
		when(courseData.getIdFile()).thenReturn(null);

		// when
		Integer idCourse = courseService.addCourse(courseData);
		Integer numCourses = courseMapper.select(SelectDSLCompleter.allRows()).size();

		// then
		assertNotEquals(0, idCourse);
		assertEquals(5, numCourses);
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
