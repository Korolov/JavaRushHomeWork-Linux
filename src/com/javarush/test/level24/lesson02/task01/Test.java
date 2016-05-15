package com.javarush.test.level24.lesson02.task01;

/**
 * Created by alexander on 01.03.16.
 */
public class Test
{
    private int number=7;

    private Test(){

    }
     Test1 t=new Test1();

    public void printSomething3()
    {
        System.out.println("Hello");
    }

    public static void main(String[] args)
    {


    }

    private Test t1 = new Test()
    {
        public  void printSomething()
        {
            System.out.println("Hello");
        }
    };

    public class Test1
    {
        public void printSomething1()
        {
            System.out.println("Hello");

        }
    }

        public class Test2 extends Test
        {
            public void printSomething1()
            {
                System.out.println("He");
                Test1 t=new Test1();
                number=8;

            }


        }
    }

