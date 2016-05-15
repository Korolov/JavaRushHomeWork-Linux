package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader r=new BufferedReader(new FileReader(args[0]));
        String line="";
        while(r.ready()){
            line=r.readLine();
            String[]words=line.split(" ");
            String name="";
            ArrayList<Integer>list=new ArrayList<Integer>();
            for(int i=0;i<words.length;i++){
                try{
                    int n=Integer.parseInt(words[i]);
                    list.add(n);

                }
                catch (Exception e){
                    name+=words[i]+" ";
                }
            }
            name=name.substring(0,name.length()-1);
            PEOPLE.add(new Person(name,new Date(list.get(2)-1900,list.get(1)-1,list.get(0))));

        }
       r.close();

    }
}
