package ru.rtech.interview.spring_zero_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rtech.interview.spring_zero_test.domain.Person;


@Configuration
public class AppConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Vasiliy");
        return person;
    }
}
