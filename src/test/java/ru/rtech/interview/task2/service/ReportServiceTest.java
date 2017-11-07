package ru.rtech.interview.task2.service;

import org.junit.Test;
import ru.rtech.interview.task2.domain.Data;
import ru.rtech.interview.task2.domain.Report;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by bshestakov on 07.11.2017.
 */
public class ReportServiceTest {

    @Test
    public void makeReport() throws Exception {
        Data sourceData = new Data(Arrays.asList(12.3d, 42.4d, 0d, 5453.3d, -1d));
        ReportService reportService = new ReportService(sourceData);
        Report report = reportService.makeReport();
        assertEquals(Double.valueOf(5508d), report.amount());
    }


}