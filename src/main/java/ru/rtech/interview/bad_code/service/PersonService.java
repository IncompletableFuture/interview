package ru.rtech.interview.bad_code.service;

import ru.rtech.interview.bad_code.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public void getAdultMaleClientsAverageBMI(long age) {
        double totalImt = 0.0;
        long countOfPerson = 0;
        double heightInMeters = 0d;
        double imt = 0d;
        List<Person> adultPersons = new ArrayList<>();
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql://fit-client-db/prod",
                    "admin",
                    "qwerty$4");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM person WHERE sex = 'male' AND age >= " + age);
            while (rs.next()) {
                Person p = new Person();
                //Retrieve by column name
                p.setId(rs.getLong("id"));
                p.setSex(rs.getString("sex"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getLong("age"));
                p.setWeight(rs.getLong("weight"));
                p.setHeight(rs.getLong("height"));
                adultPersons.add(p);
            }

            countOfPerson = adultPersons.size();
            System.out.println("Count of person: " + countOfPerson);

            for (Person p : adultPersons) {
                heightInMeters = p.getHeight() / 100d;
                imt = p.getWeight() / (Double) (heightInMeters * heightInMeters);
                totalImt += imt;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //We need to pass this string to Console, don't delete it plz
        System.out.println("Average imt - " + totalImt / countOfPerson);
    }
}
