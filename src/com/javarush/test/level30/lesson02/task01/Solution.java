package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(convertToDecimalSystem("0xafafc")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s)
    {
        if (s.charAt(0) != '0')
        {
            s = Integer.toString(Integer.parseInt(s));
        } else
        {
            if (s.charAt(1) == 'x')
            {
                int a = Integer.parseInt(s.substring(2, s.length()), 16);
                s = Integer.toString(a);
            }
            else if (s.charAt(1) == 'b')
            {
                int a = Integer.parseInt(s.substring(2, s.length()), 2);
                s = Integer.toString(a);
            }
            else
            {
                int a = Integer.parseInt(s.substring(1, s.length()), 8);
                s = Integer.toString(a);
            }


        }
        return s;
    }
}
