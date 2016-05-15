package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;


import java.io.IOException;
import java.util.List;


/**
 * Created by alexander on 28.03.16.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet=tablet;
    }

    @Override
    public String toString()
    {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet.toString();
        }
    }

    public int getTotalCookingTime(){
        int time=0;
        if(!(dishes.isEmpty()||dishes==null))
        for(Dish dish:dishes){
            time+=dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
