package ru.rtech.interview.task2.service;

import ru.rtech.interview.task2.domain.Data;
import ru.rtech.interview.task2.domain.Report;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class ReportService {


    private Data sourceData;

    public ReportService(Data sourceData) {
        this.sourceData = sourceData;
    }

    /**
     *
     * Анализ входных данных и составления отчета
     * По входным данным расчет обычно занимает 2-3 часа
     *
     * @return отчет
     */
    public Report makeReport() {

        Double amount = 0d;
        long count = 0;
        for (Double value : sourceData.values()) {
            if (value > 0) {
                amount += value;
                count++;
            } else {
                System.out.println("WARNING: Найдена неподходящая по формату позиция: " + value);
            }
        }

        return new Report(amount, count, amount / count);
    }
}
