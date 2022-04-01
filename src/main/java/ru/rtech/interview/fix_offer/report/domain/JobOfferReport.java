package ru.rtech.interview.fix_offer.report.domain;


import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import ru.rtech.interview.fix_offer.report.docx.DocGeneratorUtils;
import ru.rtech.interview.fix_offer.report.docx.WordTemplatesCache;

import java.io.ByteArrayOutputStream;

public class JobOfferReport {
    private final JobOfferParams params;

    public JobOfferReport(JobOfferParams params) {
        this.params = params;
    }

    public JobOfferReportFile docx() throws Docx4JException {
        WordprocessingMLPackage template = WordTemplatesCache.getOrCreateTemplate();
        DocGeneratorUtils.replacePlaceholders(template.getMainDocumentPart().getJaxbElement(), params);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        template.save(byteArrayOutputStream);
        return new JobOfferReportFile("JobOffer-" + params.getName() + ".docx", byteArrayOutputStream.toByteArray());
    }

}
