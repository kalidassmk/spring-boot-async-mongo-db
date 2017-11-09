package com.example.demo.repository.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.BsonString;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

import com.example.demo.configuration.MongoDbConnection;

import static com.example.demo.util.BsonToPojo.BsonToPojo;
import static com.example.demo.util.BsonToPojo.pojoToBson;
import static com.example.demo.util.IdGeneration.getKey;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private static final String STUDENT_COLLECTION = "student";

    /**
     * The Mongo db connection.
     */
    @Autowired
    MongoDbConnection mongoDbConnection;

    @Override
    public CompletableFuture<Student> registerStudent(Student student) {
        CompletableFuture<Student> future = new CompletableFuture<>();

        SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable throwable) {
                if (throwable != null) {
                    future.completeExceptionally(throwable);
                } else {
                    future.complete(student);
                }
            }
        };

        student.setStudentId(getKey());
        Document doc = pojoToBson(student);

        mongoDbConnection.getMongoConnection().getCollection(STUDENT_COLLECTION).insertOne(doc, callbackWhenFinished);
        return future;
    }

    @Override
    public CompletableFuture<Student> getStudentDetail(String studentId) {
        CompletableFuture<Student> future = new CompletableFuture<>();

        SingleResultCallback<Document> callbackWhenFinished = new SingleResultCallback<Document>() {
            @Override
            public void onResult(final Document result, final Throwable t) {
                if (t != null) {
                    t.printStackTrace();
                } else {
                    System.out.println("result = " + result);
                }

                future.complete(BsonToPojo(result, Student.class));
            }
        };

        MongoCollection<Document> reportTemplateCollection = mongoDbConnection.getMongoConnection().getCollection(STUDENT_COLLECTION);
        reportTemplateCollection.find(and(eq("studentId", studentId))).first(callbackWhenFinished);

        return future;
    }

    @Override
    public CompletableFuture<Boolean> delete(String studentId) {
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        SingleResultCallback<DeleteResult> callbackWhenFinished = new SingleResultCallback<DeleteResult>() {
            @Override
            public void onResult(final DeleteResult result, final Throwable t) {
                if (t != null) {
                    t.printStackTrace();
                } else {
                    System.out.println("deleted !" + result.getDeletedCount());
                }

                future.complete(true);

            }
        };

        mongoDbConnection.getMongoConnection().getCollection(STUDENT_COLLECTION)
                .deleteOne(and(eq("studentId", new BsonString(studentId))), callbackWhenFinished);
        return future;
    }
}
