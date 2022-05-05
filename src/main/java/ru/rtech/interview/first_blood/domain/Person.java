package ru.rtech.interview.first_blood.domain;


import java.util.Objects;

public class Person {
    private final String name;
    private final Long age;

    public Person(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public Long age() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;

        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return 67815473;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
