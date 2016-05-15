package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by alexander on 29.03.16.
 */
public class ConsoleHelper
{
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return READER.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {

        List<Dish> dishes = new ArrayList<>();
        String answer;
        writeMessage("Enter dish...(" + Dish.allDishesToString() + ")");
        while (true)
        {

             answer= readString();
            if (answer.equals("exit"))
                break;

                try{
                    dishes.add(Dish.valueOf(answer));}
                catch (IllegalArgumentException e) {
                    ConsoleHelper.writeMessage(answer + " is not detected");
                }


        }
        return dishes;

    }
}
