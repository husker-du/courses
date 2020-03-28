package com.autentia.courses;

import com.autentia.courses.persistence.model.Teacher;
import com.autentia.courses.persistence.service.TeacherService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherDbTests {

    private TeacherService teacherService;

    @Autowired
    public TeacherDbTests(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Test
    public void teacherAlbertoMoratillaShouldHaveId4() {
        // given
        String firstName = "Alberto";
        String lastName = "Moratilla";

        // when
        Teacher teacher = teacherService.getTeacherByName(firstName, lastName);

        // then
        Assert.assertNotNull(teacher);
        Assert.assertEquals(Integer.valueOf(4), teacher.getId());
    }
}
