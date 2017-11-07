package ru.rtech.interview.task2.domain;

import java.math.BigDecimal;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class Report {
    private Double amount;
    private Long count;
    private Double avg;

    public Report(Double amount, Long count, Double avg) {
        this.amount = amount;
        this.count = count;
        this.avg = avg;
    }

    public Double amount() {
        return amount;
    }

    public Long count() {
        return count;
    }

    public Double avg() {
        return avg;
    }
}
