package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Persistence;


/**
 * Created by Arij Hussain on 10/7/2016.
 */
@SpringBootApplication
public class ArijDemoAppApplication {

	public static void main(String[] args) {
		Persistence.generateSchema("PU",null);
		SpringApplication.run(ArijDemoAppApplication.class, args);
	}
}
