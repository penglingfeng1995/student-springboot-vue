package com.plf.student.service.impl;

import com.plf.student.mapper.StudentMapper;
import com.plf.student.model.Student;
import com.plf.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents(Integer start, Integer size) {

        return studentMapper.getStudents(start,size);
    }
}
