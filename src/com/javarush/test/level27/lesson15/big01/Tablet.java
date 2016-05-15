package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alexander on 28.03.16.
 */
public class Tablet extends Observable
{
    private final int number;
    final static  Logger logger=Logger.getLogger(Tablet.class.getName());
    boolean setChaged;

    public Tablet(int number)
    {
        this.number = number;
    }
    public Order createOrder() throws InterruptedException
    {
        Order order=null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChaged=true;
            try{new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();}
            catch(NoVideoAvailableException e){
                logger.log(Level.INFO,"No video is available for the order " + order);
            }
            notifyObservers(order);


            }
        catch (IOException e){
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        return order;

    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number + "}";
    }


}
