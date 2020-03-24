package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;

import java.util.List;

public interface CourseService {

    /**
     * Get all the courses from database.
     * @return  the list of all the courses.
     */
    List<Course> getAllCourses();

    /**
     * Get the active courses from database.
     * The active courses have their 'active' field set to 1.
     * @return  the list of active courses.
     */
    List<CourseData> getActiveCourseData();

    /**
     * Get the data of all the courses including the course teacher.
     * @return  the list of all the courses including the teacher of every course.
     */
    List<CourseData> getAllCourseData();

    /**
     * Get the course leves.
     * The enum in the 'LEVEL' column in database is inspected and the values of levels
     * are parsed from the enum in database.
     * @return  the list of course levels.
     */
    List<String> getCourseLevels();

    /**
     * Insert a new course into the database.
     * @param course  the course data to be inserted.
     * @return  the id of the inserted course.
     */
    int addCourse(CourseData course);
}
