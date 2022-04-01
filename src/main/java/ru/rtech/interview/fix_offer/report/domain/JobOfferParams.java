package ru.rtech.interview.fix_offer.report.domain;


public class JobOfferParams {
    private final String name;
    private final String position;
    private final String block;
    private final String practice;
    private final String trial;
    private final String bank;

    public JobOfferParams(String name, String position, String block, String practice, String trial, String bank) {
        this.name = name;
        this.position = position;
        this.block = block;
        this.practice = practice;
        this.trial = trial;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getBlock() {
        return block;
    }

    public String getPractice() {
        return practice;
    }

    public String getTrial() {
        return trial;
    }

    public String getBank() {
        return bank;
    }
}
