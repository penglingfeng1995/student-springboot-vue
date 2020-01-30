package com.plf.student.mapper;

import com.plf.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> getStudents(Integer start, Integer size);
}
