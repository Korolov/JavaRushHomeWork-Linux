package com.javarush.test.level25.lesson09.task03;

import java.util.*;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler
{


    public void uncaughtException(Thread thread, Throwable throwable)
    {
        thread.interrupt();
        ArrayList<Throwable>list=new ArrayList<Throwable>();
        list.add(throwable);
        Throwable t=throwable.getCause();
        while(t!=null){
            list.add(t);
            t=t.getCause();
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));






    }


}
