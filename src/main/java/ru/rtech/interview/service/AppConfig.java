package ru.rtech.interview.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rtech.interview.task3.domain.Person;


@Configuration
public class AppConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Vasiliy");
        return person;
    }
}
