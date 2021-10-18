package com.rog.teach.springBoot.controller;

import com.rog.teach.springBoot.entity.Student;
import com.rog.teach.springBoot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")
    public List<Student> hello(){
        return studentService.list();
    }

    @PostMapping(path = "add")
    public void add(@RequestBody Student student){
        studentService.add(student);
    }
}
