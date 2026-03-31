package com.example.springboot_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringbootPracticeApplication implements CommandLineRunner {
//	@Autowired
//	private BeanCreation beanCreation1;
//	@Autowired
//	private BeanCreation beanCreation2;

//	NotificationService notificationService;
//
//	public SpringbootPracticeApplication(NotificationService notificationService){
//		this.notificationService = notificationService;
//	}

	@Autowired   //if we want the instance of all bean then we can use map
	Map<String, NotificationService>  notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(beanCreation1.hashCode());
//		System.out.println(beanCreation2.hashCode());
//		beanCreation1.bean();
//		beanCreation2.bean();
//		notificationService.send("Hello");
//		....................................................................
//		for(var notificationService: notificationServiceMap.entrySet()){
//			System.out.println(notificationService.getKey());
//			notificationService.getValue().send("Hello");
//		}
//		...............................................................
	}


}
