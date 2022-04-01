package ru.rtech.interview.fix_offer.report;


import org.docx4j.openpackaging.exceptions.Docx4JException;
import ru.rtech.interview.fix_offer.report.domain.JobOfferParams;
import ru.rtech.interview.fix_offer.report.domain.JobOfferReport;
import ru.rtech.interview.fix_offer.report.domain.JobOfferReportFile;

public class JobOfferReportService {

    public JobOfferReportFile buildReport(JobOfferParams params) throws Docx4JException {
        return new JobOfferReport(params).docx();
    }

}
