package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        class MyHandler implements Thread.UncaughtExceptionHandler{

            @Override
            public void uncaughtException(Thread thread, Throwable throwable)
            {
                String t=thread.getName();
                String e=throwable.getMessage();
                String replaceString="";
                while(replaceString.length()<t.length())
                    replaceString+="*";
                System.out.println(e.replace(t,replaceString));

            }
        }
        this.original = original;
        this.handler = new MyHandler();
        Thread.currentThread().setUncaughtExceptionHandler(handler);
        if (original == null) {
            throw new NullPointerException();
        }



            }
    public static void main(String[]args){

        Solution s=new Solution(new TimerTask()
        {
            @Override
            public void run()
            {
                run();
            }
        });
        s.run();

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}