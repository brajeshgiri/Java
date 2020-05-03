package com.brajesh.myApp;

import jdk.nashorn.internal.ir.AccessNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);

	}

}
