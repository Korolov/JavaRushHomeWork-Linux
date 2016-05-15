package com.javarush.test.level26.lesson08.task01;

import java.util.concurrent.ExecutorService;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {

     public static class IntegerHolder{
        public  int a;
        public synchronized int  get(){
            return a;

        }

        public synchronized void set(int a)
        {
            this.a = a;
        }
    }
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                IntegerHolder h=new IntegerHolder();
                h.set(5);
            }
        });
        Thread t2=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                IntegerHolder h=new IntegerHolder();
                h.set(8);
            }
        });
        t1.start();

        t2.start();



    }
}
