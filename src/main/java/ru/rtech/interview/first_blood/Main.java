package ru.rtech.interview.first_blood;


import ru.rtech.interview.first_blood.domain.Group;
import ru.rtech.interview.first_blood.domain.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class Main {


    public static void main(String[] args) {
        Group group1 = new Group(Arrays.asList(
                new Person("Вова", 16L),
                new Person("Никита", 18L),
                new Person("Лёша", 22L)));

        Group group2 = new Group(Arrays.asList(
                new Person("Саша", 14L),
                new Person("Аня", 20L),
                new Person("Дима", 60L)));

        throw new UnsupportedOperationException("Implemented it!");
    }
    
    /**
     * Возвращает всех людей старше 18 лет.
     *
     * @param persons список групп людей
     * @return список людей старше 18 лет
     */
    public static List<Person> adultPersons(List<Group> persons) {
        throw new UnsupportedOperationException("Implemented it!");
    }

}
