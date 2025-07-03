package com.kunal.myCoolApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// We can include manually which package to scan
//@SpringBootApplication(
//		scanBasePackages = {"",""}
//)

@SpringBootApplication
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

}
