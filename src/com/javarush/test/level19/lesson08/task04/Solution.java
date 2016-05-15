package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream e = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);
        testString.printSomething();
        String data = "";
        data = array.toString();
        System.setOut(e);
        if (data.contains("+"))
        {
            String[] words = data.split("\\+");
            String[] words2 = words[1].split("\\=");
            int result = Integer.parseInt(words[0].substring(0, words[0].length() - 1)) + Integer.parseInt(words2[0].substring(1, words2[0].length() - 1));

            System.out.println(data + result);
        } else if (data.contains("-"))
        {


            String[] words = data.split("\\-");
            String[] words2 = words[1].split("\\=");
            int result = Integer.parseInt(words[0].substring(0, words[0].length() - 1)) - Integer.parseInt(words2[0].substring(1, words2[0].length() - 1));
            System.out.print(data + result);
        } else if (data.contains("*"))
        {
            String[] words = data.split("\\*");
            String[] words2 = words[1].split("\\=");
            int result = Integer.parseInt(words[0].substring(0, words[0].length() - 1)) * Integer.parseInt(words2[0].substring(1, words2[0].length() - 1));
            System.out.print(data + result);



        }
    }


        public static class TestString
        {
            public void printSomething()
            {
                System.out.print("3 + 6 = ");
            }
        }

}





