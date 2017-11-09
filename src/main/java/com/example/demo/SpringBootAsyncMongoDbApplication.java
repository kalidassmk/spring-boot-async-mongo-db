package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The type Spring boot async mongo db application.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.*"})
@EnableAsync
public class SpringBootAsyncMongoDbApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncMongoDbApplication.class, args);
	}
}
