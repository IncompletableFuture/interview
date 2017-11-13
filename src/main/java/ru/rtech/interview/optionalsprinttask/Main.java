package ru.rtech.interview.optionalsprinttask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rtech.interview.optionalsprinttask.config.AppConfig;
import ru.rtech.interview.optionalsprinttask.domain.Person;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Person p = new Person();
        System.out.println(p.getName());

    }

}
