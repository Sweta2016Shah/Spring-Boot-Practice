package com.example.springboot_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootPracticeApplication implements CommandLineRunner {
	@Autowired
	private BeanCreation beanCreation1;

	@Autowired
	private BeanCreation beanCreation2;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(beanCreation1.hashCode());
		System.out.println(beanCreation2.hashCode());
		beanCreation1.bean();
		beanCreation2.bean();
	}


}
