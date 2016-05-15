package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import static com.javarush.test.level27.lesson15.big01.ConsoleHelper.writeMessage;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexander on 28.03.16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        writeMessage(Dish.allDishesToString());
       Tablet tablet5=new Tablet(5);
        Cook cook=new Cook("Alex");
        Order order= null;
        try
        {
            order = tablet5.createOrder();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        cook.update(tablet5,order);
        Waitor waitor=new Waitor();
       waitor.update(cook,order);





    }
}
