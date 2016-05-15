package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander on 28.03.16.
 */
public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory(){

}
    private static Map<String,CurrencyManipulator> manipulators=new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(!manipulators.containsKey(currencyCode))
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        return manipulators.get(currencyCode);

    }

    public static Collection getAllCurrencyManipulators(){
        return manipulators.values();

    }

}
