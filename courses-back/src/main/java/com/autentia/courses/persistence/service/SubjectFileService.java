package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.model.SubjectFile;

public interface SubjectFileService {

    SubjectFile getFile(Integer id);

    int addFile(SubjectFile file);
}
