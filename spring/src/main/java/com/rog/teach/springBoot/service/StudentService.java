package com.rog.teach.springBoot.service;

import com.rog.teach.springBoot.entity.Student;
import com.rog.teach.springBoot.repository.StudentRepository;
import com.rog.teach.springBoot.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list(){
        return studentRepository.findAll();
    }

    public void add(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }
        studentRepository.save(student);
    }

    public void delete(Long student) {
        studentRepository.deleteById(student);
    }

    public void update(Student student) {
        Optional<Student> rowInBase = studentRepository.findById(student.getId());
        if(rowInBase.isPresent()){
            Student studentInBase = rowInBase.get();
            if(!student.getName().isEmpty()){
                studentInBase.setName(student.getName());
            }
            if(student.getDob() != null){
                studentInBase.setDob(student.getDob());
            }
            studentRepository.save(studentInBase);
        }
    }
}
