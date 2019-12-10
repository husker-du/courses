package com.autentia.courses.persistence.model;

import javax.annotation.Generated;

public class Course {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833343+01:00", comments="Source field: course.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833571+01:00", comments="Source field: course.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833765+01:00", comments="Source field: course.level")
    private String level;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833953+01:00", comments="Source field: course.hours")
    private Integer hours;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834136+01:00", comments="Source field: course.active")
    private Byte active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834317+01:00", comments="Source field: course.id_teacher")
    private Integer idTeacher;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.8345+01:00", comments="Source field: course.id_file")
    private Integer idFile;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833434+01:00", comments="Source field: course.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833507+01:00", comments="Source field: course.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833642+01:00", comments="Source field: course.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833707+01:00", comments="Source field: course.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833826+01:00", comments="Source field: course.level")
    public String getLevel() {
        return level;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.833893+01:00", comments="Source field: course.level")
    public void setLevel(String level) {
        this.level = level;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834011+01:00", comments="Source field: course.hours")
    public Integer getHours() {
        return hours;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834073+01:00", comments="Source field: course.hours")
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834196+01:00", comments="Source field: course.active")
    public Byte getActive() {
        return active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834259+01:00", comments="Source field: course.active")
    public void setActive(Byte active) {
        this.active = active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83438+01:00", comments="Source field: course.id_teacher")
    public Integer getIdTeacher() {
        return idTeacher;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834442+01:00", comments="Source field: course.id_teacher")
    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834559+01:00", comments="Source field: course.id_file")
    public Integer getIdFile() {
        return idFile;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834628+01:00", comments="Source field: course.id_file")
    public void setIdFile(Integer idFile) {
        this.idFile = idFile;
    }

    @Override
    public String toString() {
        return String.format("Course{ id=%d, title=%s, level=%s, hours=%d, active=%d, idTeacher=%d, teacher=%s",
                id, title, level, hours, active, idTeacher);
    }
}