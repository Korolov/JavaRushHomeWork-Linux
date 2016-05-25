package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.OurHashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexander on 25.05.16.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long>set=new HashSet<>();
        for(String entry:strings){
            set.add(shortener.getId(entry));
        }
        return set;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String>set=new HashSet<>();
        for(Long entry:keys){
            set.add(shortener.getString(entry));
        }
        return set;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String>strings=new HashSet<>();
        for(long i=0;i<elementsNumber;i++)
        {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener=new Shortener(strategy);
        Date date1=new Date();
        Set<Long>ids=getIds(shortener,strings);
        Date date2=new Date();
        Helper.printMessage(String.valueOf(date2.getTime()-date1.getTime()));
        date1=new Date();
        Set<String>srs=getStrings(shortener,ids);
        date2=new Date();
        Helper.printMessage(String.valueOf(date2.getTime()-date1.getTime()));
        boolean isPassed=true;
        for(String str:srs){
            if(!strings.contains(str)){
                isPassed=false;
                break;
            }
        }
        for(String str:strings){
            if(!srs.contains(str)){
                isPassed=false;
                break;
            }
        }
        if(isPassed)
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
    public static void main (String[]args){
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
    }
}
