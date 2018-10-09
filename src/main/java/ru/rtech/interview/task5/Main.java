package ru.rtech.interview.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class A {
        int a;

        public A(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "{" + a + "}";
        }
    }

    public static void main(String[] args) {
        List<A> list1 = Arrays.asList(new A(1), new A(2));
        List<A> list2 = list1.stream()
                .filter(elem -> elem.a == 1)
                .collect(Collectors.toList());
        list2.get(0).a = 4;
//        ЧТО ВЫВЕДЕТ?
        
//        System.out.println(list1);
//        System.out.println(list2);
    }
}
