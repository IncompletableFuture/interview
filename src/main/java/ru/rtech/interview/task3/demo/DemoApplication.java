package ru.rtech.interview.task3.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rtech.interview.task3.service.PersonService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		PersonService personService = new PersonService();
		personService.getAdultMaleUsersAverageBMI();
	}
}
