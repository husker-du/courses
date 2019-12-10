package com.autentia.courses.persistence.model;

import javax.annotation.Generated;

public class SubjectFile {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.17938+01:00", comments="Source field: subject_file.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179506+01:00", comments="Source field: subject_file.file_name")
    private String fileName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.17962+01:00", comments="Source field: subject_file.type")
    private String type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179745+01:00", comments="Source field: subject_file.data")
    private byte[] data;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179426+01:00", comments="Source field: subject_file.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179468+01:00", comments="Source field: subject_file.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179543+01:00", comments="Source field: subject_file.file_name")
    public String getFileName() {
        return fileName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179583+01:00", comments="Source field: subject_file.file_name")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179658+01:00", comments="Source field: subject_file.type")
    public String getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179704+01:00", comments="Source field: subject_file.type")
    public void setType(String type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179783+01:00", comments="Source field: subject_file.data")
    public byte[] getData() {
        return data;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.179822+01:00", comments="Source field: subject_file.data")
    public void setData(byte[] data) {
        this.data = data;
    }
}