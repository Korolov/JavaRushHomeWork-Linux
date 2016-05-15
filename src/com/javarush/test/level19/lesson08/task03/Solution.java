package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original=System.out;
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        PrintStream newOut=new PrintStream(stream);
        System.setOut(newOut);
        testString.printSomething();
        String data=stream.toString();
        System.setOut(original);
        String data1="";
        for(int i=0;i<data.length();i++){
            if(Character.isDigit(data.charAt(i))){

                data1+=data.charAt(i);

            }



        }
        System.out.println(data1);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
