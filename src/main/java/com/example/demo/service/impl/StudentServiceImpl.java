package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.example.demo.util.IdGeneration.getKey;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    /**
     * The Student repository.
     */
    @Autowired
    StudentRepository studentRepository;

    @Override
    public CompletableFuture<Student> registerStudent(Student student) {
        return studentRepository.registerStudent(student);
    }

    @Override
    public CompletableFuture<Student> getStudentDetail(String studentId) {
        return studentRepository.getStudentDetail(studentId);
    }

    @Override
    public CompletableFuture<Boolean> delete(String studentId) {
        return studentRepository.delete(studentId);
    }
}
