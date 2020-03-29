package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.dao.CourseMapper;
import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.autentia.courses.persistence.dao.CourseDynamicSqlSupport.title;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    private TeacherService teacherService;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper,
                             TeacherService teacherService) {
        this.courseMapper = courseMapper;
        this.teacherService = teacherService;
    }

    @Override
    public List<Course> getAllCourses() {
        // The courses are sorted by title
        return courseMapper.select(SelectDSLCompleter.allRowsOrderedBy(title));
    }

    @Override
    public List<CourseData> getActiveCourseData() {
        return getAllCourses().stream()
                .filter(course -> course.getActive().byteValue() == (byte)1)
                .map(course -> {
                    Teacher teacher = teacherService.getTeacherById(course.getIdTeacher());
                    return new CourseData(course.getId(), course.getTitle(), course.getLevel(),
                            course.getHours(), course.getActive(), course.getIdFile(), course.getIdTeacher(), teacher);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseData> getAllCourseData() {
        List<CourseData> courseList = new ArrayList<>();
        for (Course course : getAllCourses()) {
            Teacher teacher = teacherService.getTeacherById(course.getIdTeacher());
            if (teacher != null) {
                CourseData courseData = new CourseData(course.getId(), course.getTitle(), course.getLevel(),
                        course.getHours(), course.getActive(), course.getIdFile(), course.getIdTeacher(), teacher);
                courseList.add(courseData);
            }
        }
        return courseList;
    }

    @Override
    public int addCourse(CourseData courseData) {
        int id = 0;
        Course course = new Course();
        course.setTitle(courseData.getTitle());
        course.setLevel(courseData.getLevel());
        course.setActive(courseData.getActive());
        course.setHours(courseData.getHours());
        course.setIdFile(courseData.getIdFile());

        // Set the teacher id into the course data
        Teacher teacher = courseData.getTeacher();
        if (teacher != null) {
            Teacher teacherDb = teacherService.getTeacherByName(teacher.getFirstName(), teacher.getLastName());
            if (teacherDb != null) {
                course.setIdTeacher(teacherDb.getId());
            }
        }

        // Insert the course data into database
        if (courseMapper.insert(course) > 0) {
            id = course.getId();
        }

        return id;
    }
}
