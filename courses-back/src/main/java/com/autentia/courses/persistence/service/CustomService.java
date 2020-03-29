package com.autentia.courses.persistence.service;

import java.util.List;

public interface CustomService {
    /**
     * Get the course leves.
     * The enum in the 'LEVEL' column in database is inspected and the values of levels
     * are parsed from the enum in database.
     * @return  the list of course levels.
     */
    List<String> getCourseLevels();
}
