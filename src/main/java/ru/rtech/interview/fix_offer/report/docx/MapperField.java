package ru.rtech.interview.fix_offer.report.docx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by sanasov on 10.05.2016.
 * Класс - набор статических методов для создания маппинга.
 * Похожая идея работы с шаболном реализована во фреймворке jxls
 */
public class MapperField {
    private final static String billingDomainPackage = "ru.rtech.interview";

    /**
     * По заданному объекту доменной модели биллинга создается маппинг из названия его полей и их значений,
     * включая поля, принадлежащие доменной модели уровнем ниже(поля полей)
     * @param  obj - объект доменной модели биллинга
     * @param  result - результирующий маппинг
     */
    public static void convertObjectFieldsToMap(Object obj, Map<String, String> result) {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (obj == null || !isObjectFromBillingDomain(obj)) {
            return;
        }

        for (Field field : fields) {
            Object fieldObject = getFieldObjectCallingGetMethodOfField(obj, field);
            String fieldObjectValue = "-";
            if (fieldObject != null) {
                fieldObjectValue = fieldObject.toString();
                convertObjectFieldsToMap(fieldObject, result);

            }
            result.put(field.getName(), fieldObjectValue);

        }

    }

    private static Object getFieldObjectCallingGetMethodOfField(Object obj, Field field) {
        Class clazz = obj.getClass();
        try {
            Method method = clazz.getMethod(getMethodNameByFieldName(field.getName()));
            return method.invoke(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getMethodNameByFieldName(String fieldName) {
        return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    private static boolean isObjectFromBillingDomain(Object obj) {
        return obj.getClass().getPackage().getName().contains(billingDomainPackage);
    }

}
