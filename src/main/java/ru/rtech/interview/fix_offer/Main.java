package ru.rtech.interview.fix_offer;

import org.apache.commons.io.FileUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import ru.rtech.interview.fix_offer.report.JobOfferReportService;
import ru.rtech.interview.fix_offer.report.domain.JobOfferParams;
import ru.rtech.interview.fix_offer.report.domain.JobOfferReportFile;

import java.io.File;
import java.io.IOException;

/**
 * Изменить приложение так, чтобы документ формировался с блоком зарплата описанным в документе Job_offer_liga_new_req.docx.
 * Значение зарплаты должно быть параметризуемым.
 */
public class Main {
    public static void main(String[] args) throws Docx4JException, IOException {
        JobOfferReportFile jobOfferReportFile = new JobOfferReportService().buildReport(
                new JobOfferParams("Юрий",
                        "Разработчик",
                        "БКС",
                        "ITSM",
                        "три месяца",
                        "Сбербанк"));
        FileUtils.writeByteArrayToFile(new File(jobOfferReportFile.getFilename()), jobOfferReportFile.getContent());
    }
}
