package ru.rtech.interview.first_blood.domain;

import java.util.List;

public class Group {
    private final List<Person> people;

    public Group(List<Person> people) {
        this.people = people;
    }

    public List<Person> people() {
        return people;
    }
}
