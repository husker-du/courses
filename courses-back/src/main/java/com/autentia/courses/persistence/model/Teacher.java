package com.autentia.courses.persistence.model;

import javax.annotation.Generated;

public class Teacher {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.858087+01:00", comments="Source field: teacher.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861289+01:00", comments="Source field: teacher.first_name")
    private String firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.86155+01:00", comments="Source field: teacher.last_name")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861731+01:00", comments="Source field: teacher.age")
    private Integer age;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.860882+01:00", comments="Source field: teacher.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861193+01:00", comments="Source field: teacher.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861384+01:00", comments="Source field: teacher.first_name")
    public String getFirstName() {
        return firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.8615+01:00", comments="Source field: teacher.first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861604+01:00", comments="Source field: teacher.last_name")
    public String getLastName() {
        return lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861664+01:00", comments="Source field: teacher.last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861834+01:00", comments="Source field: teacher.age")
    public Integer getAge() {
        return age;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.861939+01:00", comments="Source field: teacher.age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Teacher {id=%d, firstName=%s, lastName=%s, age=%d}",
                id, firstName, lastName, age);
    }
}