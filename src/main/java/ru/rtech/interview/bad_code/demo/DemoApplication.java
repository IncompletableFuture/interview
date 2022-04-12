package ru.rtech.interview.bad_code.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rtech.interview.bad_code.service.PersonService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		PersonService personService = new PersonService();
		personService.getAdultMaleClientsAverageBMI(15);
	}
}
