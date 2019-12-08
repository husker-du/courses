package com.autentia.courses.persistence.model;

import javax.annotation.Generated;

public class Course {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887028+01:00", comments="Source field: course.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887184+01:00", comments="Source field: course.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88731+01:00", comments="Source field: course.level")
    private String level;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887432+01:00", comments="Source field: course.hours")
    private Integer hours;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887594+01:00", comments="Source field: course.active")
    private Byte active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887838+01:00", comments="Source field: course.id_teacher")
    private Integer idTeacher;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887091+01:00", comments="Source field: course.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887146+01:00", comments="Source field: course.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887226+01:00", comments="Source field: course.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88727+01:00", comments="Source field: course.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88735+01:00", comments="Source field: course.level")
    public String getLevel() {
        return level;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887393+01:00", comments="Source field: course.level")
    public void setLevel(String level) {
        this.level = level;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887475+01:00", comments="Source field: course.hours")
    public Integer getHours() {
        return hours;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887536+01:00", comments="Source field: course.hours")
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887671+01:00", comments="Source field: course.active")
    public Byte getActive() {
        return active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887793+01:00", comments="Source field: course.active")
    public void setActive(Byte active) {
        this.active = active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887879+01:00", comments="Source field: course.id_teacher")
    public Integer getIdTeacher() {
        return idTeacher;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.887919+01:00", comments="Source field: course.id_teacher")
    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }
}