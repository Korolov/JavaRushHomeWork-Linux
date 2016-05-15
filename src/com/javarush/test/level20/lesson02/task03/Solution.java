package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        try{BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine(), null);
        reader.close();
        load(new FileInputStream(file));}
        catch (Exception e){
        e.printStackTrace();
    }


    }

    public void save(OutputStream outputStream) throws Exception
    {

        Properties prop = new Properties();
        try{for (Map.Entry x : properties.entrySet())
        {
            prop.put(x.getKey(),x.getValue());
        }
        prop.store(outputStream, null);
        outputStream.close();}
        catch (Exception e){
            e.printStackTrace();
        }



    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();


        try
        {
            prop.load(inputStream);
            for (String x : prop.stringPropertyNames())
            {
                properties.put(x, prop.getProperty(x));
            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }


    }
}

