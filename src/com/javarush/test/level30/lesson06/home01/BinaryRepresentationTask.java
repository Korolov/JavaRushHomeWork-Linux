package com.javarush.test.level30.lesson06.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by alexander on 02.05.16.
 */
public class BinaryRepresentationTask extends RecursiveTask
{
    int number;
    String result="";
    public BinaryRepresentationTask(int number)
    {
        this.number=number;
    }

    @Override
    protected String compute()
    {
        List<BinaryRepresentationTask> subTasks=new LinkedList<>();

        int a = number % 2;
        int b = number / 2;
       result += String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task=new BinaryRepresentationTask(b);
            task.fork();
            subTasks.add(task);

        }
        for(BinaryRepresentationTask task:subTasks){
            result=task.join()+result;
        }
        return result;
    }
}
