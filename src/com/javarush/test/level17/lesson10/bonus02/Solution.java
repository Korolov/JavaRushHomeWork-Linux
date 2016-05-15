package com.javarush.test.level17.lesson10.bonus02;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
       synchronized (allPeople){
           if(args[0].equals("-c")){
               SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
               String[]list=new String[args.length-1];
               for(int i=1;i<args.length;i++){
                   list[i-1]=args[i];
               }

               for(int i=0;i<list.length/3;i++){

                   if(list[i*3+1].equals("м")){
                       try
                       {
                           allPeople.add(Person.createMale(list[i*3], format.parse(list[i*3+2])));
                       }
                       catch (ParseException e)
                       {

                       }
                   }
                   else
                       try
                       {
                           allPeople.add(Person.createFemale(list[i*3],format.parse(list[i*3+2])));
                       }
                       catch (ParseException e)
                       {

                       }
                   System.out.println(allPeople.size()-1);
               }

           }

           if(args[0].equals("-u")){
               SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
               String[]list=new String[args.length-1];
               for(int i=1;i<args.length;i++){
                   list[i-1]=args[i];
               }
               for(int i=0;i<list.length/4;i++){

                   int position=Integer.parseInt(list[i*4]);
                   Person person=allPeople.get(position);
                   person.setSex(list[i*4+2].equals("м")? Sex.MALE: Sex.FEMALE);
                   try
                   {
                       person.setBirthDay(format.parse(list[i*4+3]));
                   }
                   catch (ParseException e)
                   {

                   }
                   person.setName(list[i*4+1]);
               }
           }
           if(args[0].equals("-d")){

               for(int i=1;i<args.length;i++){

                   Person person=allPeople.get(Integer.parseInt(args[i]));
                   person.setName(null);
                   person.setSex(null);
                   person.setBirthDay(null);
               }
           }
           if(args[0].equals("-i")){
               int index;
               for(int i=1;i<args.length;i++){
                   index=Integer.parseInt(args[i]);
                   String name=allPeople.get(index).getName();
                   String sex=allPeople.get(index).getSex().equals(Sex.MALE)?"м":"ж";
                   String bd=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay());
                   System.out.println(name+" "+sex+" "+ bd);
               }
           }
       }
    }
}
