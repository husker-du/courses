package com.autentia.courses.persistence.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CourseData extends Course {
    private Teacher teacher;

    public CourseData(final Integer id, final String title, final String level, final Integer hours,
                      final Byte active, final Integer idFile, final Integer idTeacher, final Teacher teacher) {
        super.setId(id);
        super.setTitle(title);
        super.setLevel(level);
        super.setHours(hours);
        super.setActive(active);
        super.setIdTeacher(idTeacher);
        super.setIdFile(idFile);
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(final Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CourseData that = (CourseData) o;

        return new EqualsBuilder()
                .append(teacher, that.teacher)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(teacher)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.format("CourseData{ id=%d, title=%s, level=%s, hours=%d, active=%d, idFile=%d, idTeacher=%d, teacher=%s }",
                getId(), getTitle(), getLevel(), getHours(), getActive(), getIdFile(), getIdTeacher(), teacher);
    }
}
