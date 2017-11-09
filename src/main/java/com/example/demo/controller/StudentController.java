package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
@RestController
public class StudentController {

    /**
     * The Student service.
     */
    @Autowired
    StudentService studentService;

    /**
     * Register student completable future.
     *
     * @param student the student
     *
     * @return the completable future
     */
    @Async
    @RequestMapping(value = "/register", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CompletableFuture<Student> registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    /**
     * Gets student detail.
     *
     * @param studentId the student id
     *
     * @return the student detail
     */
    @Async
    @RequestMapping(value = "/detail", method = GET, produces = APPLICATION_JSON_VALUE)
    public CompletableFuture<Student> getStudentDetail(@RequestParam String studentId) {
        return studentService.getStudentDetail(studentId);
    }

    /**
     * Delete completable future.
     *
     * @param studentId the student id
     *
     * @return the completable future
     */
    @Async
    @RequestMapping(value = "/delete", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public CompletableFuture<Boolean> delete(@RequestParam String studentId) {
        return studentService.delete(studentId);
    }

}
