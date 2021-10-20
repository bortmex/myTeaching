package com.rog.teach.springBoot.repository;

import com.rog.teach.springBoot.entity.Student;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);

    Optional<Student> findStudentByEmail(String email);
}
