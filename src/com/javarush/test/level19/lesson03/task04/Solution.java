package com.javarush.test.level19.lesson03.task04;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {


    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        public PersonScannerAdapter(Scanner sc){
            this.scanner=sc;
        }

        @Override
        public Person read() throws IOException
        {
          Person person=null;
            if(scanner.hasNext()){
                String str=scanner.nextLine();
                String[]words=str.split(" ");
                int day, month, year;
                day=Integer.parseInt(words[3]);
                month=Integer.parseInt(words[4])-1;
                year=Integer.parseInt(words[5]);
                Date date=(new GregorianCalendar(year,month, day)).getTime();
                person=new Person(words[1],words[2],words[0],date);


            }


            return person;
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();

        }
    }
}
