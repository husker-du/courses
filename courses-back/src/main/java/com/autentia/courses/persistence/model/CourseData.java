package com.autentia.courses.persistence.model;

public class CourseData extends Course {
    private String teacher;

    public CourseData(Integer id, String title, String level,
                      Integer hours, Byte active, Integer idTeacher, String teacher) {
        super.setId(id);
        super.setTitle(title);
        super.setLevel(level);
        super.setHours(hours);
        super.setActive(active);
        super.setIdTeacher(idTeacher);
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return String.format("CourseData{ id=%d, title=%s, level=%s, hours=%d, active=%d, idTeacher=%d, teacher=%s",
                getId(), getTitle(), getLevel(), getHours(), getActive(), getId(), teacher);
    }
}
