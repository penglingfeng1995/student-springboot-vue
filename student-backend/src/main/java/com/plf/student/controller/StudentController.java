package com.plf.student.controller;

import com.plf.student.model.Student;
import com.plf.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plf
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudents")
    public List<Student> getStudents(
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "size", required = false, defaultValue = "5") Integer size) {
        return studentService.getStudents(start,size);
    }
}
