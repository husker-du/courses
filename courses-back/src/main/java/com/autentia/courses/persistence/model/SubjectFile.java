package com.autentia.courses.persistence.model;

import javax.annotation.Generated;

public class SubjectFile {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.963748+01:00", comments="Source field: subject_file.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.96386+01:00", comments="Source field: subject_file.file_name")
    private String fileName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.96397+01:00", comments="Source field: subject_file.type")
    private String type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964079+01:00", comments="Source field: subject_file.data")
    private byte[] data;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.963787+01:00", comments="Source field: subject_file.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.963826+01:00", comments="Source field: subject_file.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.963895+01:00", comments="Source field: subject_file.file_name")
    public String getFileName() {
        return fileName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.963935+01:00", comments="Source field: subject_file.file_name")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964005+01:00", comments="Source field: subject_file.type")
    public String getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964046+01:00", comments="Source field: subject_file.type")
    public void setType(String type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964114+01:00", comments="Source field: subject_file.data")
    public byte[] getData() {
        return data;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964151+01:00", comments="Source field: subject_file.data")
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("SubjectFile {id=%d, fileName=%s, type=%s}",
                id, fileName, type);
    }
}