package ru.rtech.interview.fix_offer.report.docx;

import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

import javax.xml.bind.JAXBElement;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by sanasov on 10.05.2016.
 * Класс - набор статических методов для генерации документа в формате docx на основе библиотеки docx4
 */
public class DocGeneratorUtils {

    /**
     * Возвращает шаблон, задав к нему путь
     * @return
     */
    public static WordprocessingMLPackage getTemplate(String name) {
        WordprocessingMLPackage template = null;
        try (InputStream is = DocGeneratorUtils.class.getClassLoader().getResourceAsStream(name)) {
            template = WordprocessingMLPackage.load(is);
        } catch (Docx4JException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<>();
        if (obj instanceof JAXBElement) {
            obj = ((JAXBElement<?>) obj).getValue();
        }

        if (obj.getClass().equals(toSearch)) {
            result.add(obj);
        } else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }

    /**
     * Замещает placeholders данными из obj
     * @param  documentObject - объект из wml-дерева объектов документа, например таблицы
     * @param  obj - объект с данными, которые замещают placeholders
     */
    public static void replacePlaceholders(Object documentObject, Object obj) {
        Map<String, String> mapFields = new HashMap<>();
        MapperField.convertObjectFieldsToMap(obj, mapFields);
        mapFields.forEach((key, value) -> replacePlaceholder(documentObject, value, key));
    }

    private static void replacePlaceholder(Object documentObject, String name, String placeholder) {
        List<Object> texts = getAllElementFromObject(documentObject, Text.class);
        for (Object text : texts) {
            Text textElement = (Text) text;
            if (textElement.getValue().equals(placeholder)) {
                textElement.setValue(name);
            }
        }
    }

    /**
     * Заполняет таблицу данными, добавляя строки
     * @param  templateTable - wml-объект, соответсвующий таблице документа
     * @param  maps - список ассоцированый массивов данных для создания и заполения строк в таблице
     */
    public static void replaceTable(Tbl templateTable, List<Map<String, String>> maps) {
        // 1. find the table
        List<Object> rows = getAllElementFromObject(templateTable, Tr.class);
        // first row is header, second row is content
        // this is our template row
        Tr templateRow = (Tr) rows.get(3);

        int indexRow = 4;
        for (Map<String, String> replacements : maps) {
            // 2 and 3 are done in this method
            addRowToTable(indexRow, templateTable, templateRow, replacements);
            indexRow++;
        }

        // 4. remove the template row
        templateTable.getContent().remove(templateRow);
    }

    private static void addRowToTable(int index, Tbl reviewTable, Tr templateRow, Map<String, String> replacements) {
        Tr workingRow = XmlUtils.deepCopy(templateRow);
        replacements.forEach((key, value) -> DocGeneratorUtils.replacePlaceholder(workingRow, value, key));

        //add numeration to rows
        int rowNumber = index - 1;
        DocGeneratorUtils.replacePlaceholder(workingRow, String.valueOf(rowNumber), "rowNum");

        reviewTable.getContent().add(index, workingRow);
    }

    /**
     * Возвращает объект-wml, соответсвующий таблице из шаблона
     * @param  template - объект, соответсвующий документу
     * @param  templateTableKey - ключ, по которому производится поиск таблицы
     */
    public static Tbl getTemplateTableByKey(WordprocessingMLPackage template, String templateTableKey) {
        List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);
        for (Iterator<Object> iterator = tables.iterator(); iterator.hasNext(); ) {
            Object tbl = iterator.next();
            List<?> textElements = getAllElementFromObject(tbl, Text.class);
            for (Object text : textElements) {
                Text textElement = (Text) text;
                if (textElement.getValue() != null && textElement.getValue().equals(templateTableKey)) {
                    return (Tbl) tbl;
                }
            }
        }
        return null;
    }

    /**
     * Возвращает список ассоцированый массивов данных для создания и заполения строк в таблице
     * @param  records - список dto-объектов
     */
    public static List<Map<String, String>> retrievePlaceholderMaps(List records) {
        List<Map<String, String>> maps = new ArrayList<>();

        for (Object record : records) {
            Map<String, String> rowMap = new HashMap<>();
            MapperField.convertObjectFieldsToMap(record, rowMap);
            maps.add(rowMap);
        }
        return maps;
    }


}