package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
public interface StudentRepository {
    /**
     * Register student completable future.
     *
     * @param student the student
     *
     * @return the completable future
     */
    CompletableFuture<Student> registerStudent(Student student);

    /**
     * Gets student detail.
     *
     * @param studentId the student id
     *
     * @return the student detail
     */
    CompletableFuture<Student> getStudentDetail(String studentId);

    /**
     * Delete completable future.
     *
     * @param studentId the student id
     *
     * @return the completable future
     */
    CompletableFuture<Boolean> delete(String studentId);
}
