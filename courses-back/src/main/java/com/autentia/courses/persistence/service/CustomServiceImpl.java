package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.dao.CourseMapper;
import com.autentia.courses.persistence.dao.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CustomServiceImpl implements CustomService {

    private CustomMapper customMapper;

    @Autowired
    public CustomServiceImpl(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Override
    public List<String> getCourseLevels() {
        List<String> levels = new ArrayList<>();

        // Get the level enum description from database
        String levelEnum = customMapper.findLevelColumnType();

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

}
