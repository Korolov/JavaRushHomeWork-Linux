package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file=args[0];
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String line="";
        HashMap<String, Double> map=new HashMap<String, Double>();
        while(reader.ready()){
            line=reader.readLine();
            String name=line.split(" ")[0];
            Double value=Double.parseDouble(line.split(" ")[1]);
            if(map.containsKey(name)){
                map.put(name,value+map.get(name));
            }
            else
                map.put(name,value);
        }
        reader.close();
        ArrayList<String> array=new ArrayList<String>();
        ArrayList<Double>list=new ArrayList<Double>();
        double max=Double.MIN_VALUE;
        for(Map.Entry e:map.entrySet()){
            Double number=((Double) e.getValue());
            if(number>max){
                max=number;
            }
        }
        for(Map.Entry item:map.entrySet()){
            Double value= (Double) item.getValue();
            if(value==max){
                System.out.println((String)item.getKey());}
        }

    }
}
