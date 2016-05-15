package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexander on 30.03.16.
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook(String name)
    {
        this.name=name;
    }

    @Override
    public String toString()
    {
        return name;
    }


    public void update(Observable observable, Object o)
    {
        Order order=(Order)o;
        if(!order.isEmpty()){
            ConsoleHelper.writeMessage("Start cooking - " + order+", cooking time "+order.getTotalCookingTime()+"min");
            setChanged();
            notifyObservers(order);
        }


    }
}
