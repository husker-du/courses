package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.mapper.SubjectFileMapper;
import com.autentia.courses.persistence.model.SubjectFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectFileServiceImpl implements SubjectFileService {

    private SubjectFileMapper fileMapper;

    @Autowired
    public SubjectFileServiceImpl(SubjectFileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public SubjectFile getFile(Integer id) {
        SubjectFile file = null;
        Optional<SubjectFile> optFile = fileMapper.selectByPrimaryKey(id);
        if (optFile.isPresent()) {
            file = optFile.get();
        }
        return file;
    }

    @Override
    public int addFile(SubjectFile file) {
        int id = 0;
        if (fileMapper.insert(file) > 0) {
            id = file.getId();
        }
        return id;
    }
}
