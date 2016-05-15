package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexander on 30.03.16.
 */
public class Waitor implements Observer
{
    @Override
    public void update(Observable observable, Object o)
    {
        Cook cook=(Cook)observable;
        Order order=(Order)o;
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
    }
}
