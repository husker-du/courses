package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.dao.CourseMapper;
import com.autentia.courses.persistence.dao.CustomMapper;
import com.autentia.courses.persistence.dao.TeacherMapper;
import com.autentia.courses.persistence.model.Course;
import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.autentia.courses.persistence.dao.CourseDynamicSqlSupport.title;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    private TeacherMapper teacherMapper;

    private CustomMapper customMapper;

    private TeacherService teacherService;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper,
                             TeacherMapper teacherMapper,
                             CustomMapper customMapper,
                             TeacherService teacherService) {
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
        this.customMapper = customMapper;
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
                    Teacher teacher = null;
                    Optional<Teacher> optTeacher = teacherMapper.selectByPrimaryKey(course.getIdTeacher());
                    if (optTeacher.isPresent()) {
                        teacher = optTeacher.get();
                    }
                    return new CourseData(course.getId(), course.getTitle(), course.getLevel(),
                            course.getHours(), course.getActive(), course.getIdFile(), course.getIdTeacher(), teacher);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseData> getAllCourseData() {
        List<CourseData> courseList = new ArrayList<>();
        for (Course course : getAllCourses()) {
            Optional<Teacher> optTeacher = teacherMapper.selectByPrimaryKey(course.getIdTeacher());
            if (optTeacher.isPresent()) {
                Teacher teacher = optTeacher.get();
                CourseData courseData = new CourseData(course.getId(), course.getTitle(), course.getLevel(),
                        course.getHours(), course.getActive(), course.getIdFile(), course.getIdTeacher(), teacher);
                courseList.add(courseData);
            }
        }
        return courseList;
    }

    @Override
    public List<String> getCourseLevels() {
        List<String> levels = new ArrayList<>();

        // Get the level enum description from database
        String levelEnum = customMapper.getLevelEnum();

        // Create a pattern object
        Pattern pattern = Pattern.compile("enum\\(([\\W\\w]+)\\)");

        // Create a matcher object
        Matcher matcher = pattern.matcher(levelEnum);

        // Extract the levels from the enum comma-separated string
        if (matcher.find()  &&  matcher.groupCount() == 1) {
            String[] enums = matcher.group(1).split(",");
            // Remove quotes and convert to a list of strings
            levels = Arrays.stream(enums)
                    .map(e -> e.replace("\'", ""))
                    .collect(Collectors.toList());
        }
        return levels;
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
