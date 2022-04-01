package ru.rtech.interview.spring_zero_test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rtech.interview.spring_zero_test.domain.Person;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Person p = new Person();
        System.out.println(p.getName());

    }

}
