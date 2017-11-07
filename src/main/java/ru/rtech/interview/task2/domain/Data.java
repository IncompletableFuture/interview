package ru.rtech.interview.task2.domain;

import java.util.List;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class Data {
    private List<Double> numbers;

    public Data(List<Double> numbers) {
        this.numbers = numbers;
    }

    public List<Double> values() {
        return numbers;
    }
}
