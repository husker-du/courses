package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;

import java.util.Collection;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    List<CourseData> getActiveCourseData();

    List<CourseData> getAllCourseData();

    List<String> getCourseLevels();

    List<String> getCourseTestLevels();

    int addCourse(CourseData course);
}
