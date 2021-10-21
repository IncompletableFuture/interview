package ru.rtech.interview.task6;

/*
  На вход идёт список строк. Каждая строка - сообщение из телеграмма, в котором может быть кто-то упомянут.
  Упонимание начинается с символа @ и заканчивается запятой, или пробелом. Например:

  @Vasya, @rtor ответь на письмо
  @rtor @vkoba Почему лежит прод?

  Необходимо реализовать метод, который получает на вход список сообщений, а на выходе возвращает всех упомянутых в них участников,
  отсортированных по частоте упоминания сверху сниз. Если частота упоминания одинакова - порядок неважен. Например, в примере выше,
  результатом работы метода будет выход:

  rtor
  vasya
  vkoba

  Тестовые данные:

        List<String> tgMessages = new ArrayList<>();
        tgMessages.add("@Vasya, @rtor ответь на письмо");
        tgMessages.add("@rtor @vkoba Почему лежит прод?");
        tgMessages.add("Прод подняли");
        tgMessages.add("@vkoba спасибо");
 */


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }
}