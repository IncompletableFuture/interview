package ru.rtech.interview.fix_offer.report.domain;



public class JobOfferReportFile {
    private String filename;
    private byte[] content;


    public JobOfferReportFile(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }
}
