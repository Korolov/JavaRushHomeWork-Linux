package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {

       if (args[0].equals("-c")){
           SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
           if(args[2].equals("м")){
               allPeople.add(Person.createMale(args[1], format.parse(args[3])));
           }
           else
               allPeople.add(Person.createFemale(args[1],format.parse(args[3])));
           System.out.println(allPeople.size()-1);
       }
        if(args[0].equals("-u")){
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            int position=Integer.parseInt(args[1]);

            Person person=allPeople.get(Integer.parseInt(args[1]));
            person.setSex(args[3].equals("м")?Sex.MALE:Sex.FEMALE);
            person.setBirthDay(format.parse(args[4]));
            person.setName(args[2]);

        }

        if(args[0].equals("-d")){
            Person person=allPeople.get(Integer.parseInt(args[1]));
            person.setSex(null);
            person.setBirthDay(null);
            person.setName(null);
        }

        if(args[0].equals("-i")){
            int index=Integer.parseInt(args[1]);
            String name=allPeople.get(index).getName();
            String sex=allPeople.get(index).getSex().equals(Sex.MALE)?"м":"ж";
            String bd=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay());
            System.out.println(name+" "+sex+" "+ bd);
        }

    }
}
