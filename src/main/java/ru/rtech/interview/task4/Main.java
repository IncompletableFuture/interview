package ru.rtech.interview.task4;

import ru.rtech.interview.task4.domain.Data;
import ru.rtech.interview.task4.domain.Report;
import ru.rtech.interview.task4.service.ReportService;

import java.util.Arrays;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class Main {

    public static void main(String[] args) {
        Data sourceData = getData();
        ReportService reportService = new ReportService(sourceData);
        Report report = reportService.makeReport();
        System.out.println(report.amount());
    }

    private static Data getData() {
        return new Data(Arrays.asList(12.3d, 42.4d, 0d, 5453.3d, -1d));
    }

}
