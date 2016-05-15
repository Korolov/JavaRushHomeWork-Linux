package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Alexander on 17.11.2015.
 */
public abstract class DrinkMaker
{
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour() ;
    final void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
