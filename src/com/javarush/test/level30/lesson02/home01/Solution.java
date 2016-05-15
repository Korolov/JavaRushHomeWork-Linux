package com.javarush.test.level30.lesson02.home01;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        Number number = new Number(NumerationSystemType._10, "10");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem)
    {


            if(!number.getDigit().matches("^[1-9,a,b,c,d,e,f][0-9,a,b,c,d,e,f]*$"))
                throw new NumberFormatException();

            Integer.parseInt(number.getDigit());
            int base = number.getNumerationSystem().getNumerationSystemIntValue();
            int baseFinal = expectedNumerationSystem.getNumerationSystemIntValue();
            long result = 0;
            String digits = number.getDigit();

            for (int i = 0; i < digits.length(); i++)
            {
                String digit = String.valueOf(digits.charAt(digits.length() - i - 1));
                int digit1;

                if (digit.equals("a"))
                    digit1=10;
                else if (digit.equals("b"))
                    digit1=11;
                else if (digit.equals("c"))
                    digit1=12;
                else if (digit.equals("d"))
                    digit1=13;
                else if (digit.equals("e"))
                    digit1=14;
                else if (digit.equals("f"))
                    digit1=15;
                else
                    digit1=Integer.parseInt(digit);
                if(digit1>=base)
                    throw  new NumberFormatException();

                result += digit1 * Math.pow(base, i);
            }




            StringBuilder result2 = new StringBuilder("");
            while (result >= baseFinal)
            {
                long digit = result % baseFinal;
                if(baseFinal==12){
                    if (digit == 10)
                        result2.insert(0, "a");
                    else if (digit == 11)
                        result2.insert(0, "b");
                    else if (digit == 11)
                        result2.insert(0, "b");
                    else
                        result2.insert(0,digit);
                }
                else if(baseFinal==16){
                    if (digit == 10)
                        result2.insert(0, "a");
                    else if (digit == 11)
                        result2.insert(0, "b");
                    else if (digit == 11)
                        result2.insert(0, "b");
                    else if (digit == 12)
                        result2.insert(0, "c");
                    else if (digit == 13)
                        result2.insert(0, "d");
                    else if (digit == 14)
                        result2.insert(0, "e");
                    else if (digit == 15)
                        result2.insert(0, "f");
                    else
                        result2.insert(0,digit);
                }
                else
                    result2.insert(0,digit);


                result = result / baseFinal;
            }
            if(baseFinal==12){
                if (result == 10)
                    result2.insert(0, "a");
                else if (result == 11)
                    result2.insert(0, "b");
                else if (result == 11)
                    result2.insert(0, "b");
                else
                    result2.insert(0,result);
            }
            else if(baseFinal==16){
                if (result == 10)
                    result2.insert(0, "a");
                else if (result == 11)
                    result2.insert(0, "b");
                else if (result == 11)
                    result2.insert(0, "b");
                else if (result == 12)
                    result2.insert(0, "c");
                else if (result == 13)
                    result2.insert(0, "d");
                else if (result == 14)
                    result2.insert(0, "e");
                else if (result == 15)
                    result2.insert(0, "f");
                else
                    result2.insert(0,result);
            }
            else
                result2.insert(0,result);


            return new Number(expectedNumerationSystem, String.valueOf(result2));






    }
}