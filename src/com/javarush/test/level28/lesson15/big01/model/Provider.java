package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by alexander on 15.05.16.
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }



    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

   public  List<Vacancy> getJavaVacancies(String searchString) throws IOException
   {
        return strategy.getVacancies(searchString);
    }

}
