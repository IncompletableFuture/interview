package ru.rtech.interview.fix_offer.report.docx;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * Кэш с темплейтами для отчётов
 */
public class WordTemplatesCache {
    private static WordprocessingMLPackage template;

    /**
     * Возвращает из кэша копию шаблона для отчёта на русском языке
     * Если в кэше такого шаблона нет, то пытается создать такой шаблон
     */
    public static WordprocessingMLPackage getOrCreateTemplate() {
        if (template == null) {
            template = DocGeneratorUtils.getTemplate("Job_offer_liga_template.docx");
        }
        return (WordprocessingMLPackage) template.clone();
    }

}
