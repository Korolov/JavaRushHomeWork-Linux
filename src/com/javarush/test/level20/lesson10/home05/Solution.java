package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static void main(String args[]) throws IOException, ClassNotFoundException
    {
        File file=File.createTempFile("/home/",null);
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));

        Person saved=new Person("Alex","Korolov","Russia",Sex.MALE);
        out.writeObject(saved);
        Person loaded=(Person)in.readObject();
        System.out.println(loaded.equals(saved));
    }

    public static class Person implements Serializable{
         String firstName;
        String lastName;
         transient String fullName;
         transient final String greetingString="Hello, ";
         String country;
        Sex sex;
        transient PrintStream outputStream;
         transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);

            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
        Person(){}


    }

    enum Sex {
        MALE,
        FEMALE
    }
}
