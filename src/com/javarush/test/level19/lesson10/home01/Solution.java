package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file=args[0];
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String line="";
        HashMap <String, Double>map=new HashMap<String, Double>();
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
        ArrayList<String>array=new ArrayList<String>();
        for(Map.Entry e:map.entrySet()){
            array.add((String) e.getKey());
        }
        Collections.sort(array);
        for(String item:array){
            System.out.println(item+" "+map.get(item));
        }
    }
}
