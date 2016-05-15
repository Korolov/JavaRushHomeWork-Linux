package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/



public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String data;

        while(!(data=r.readLine()).equals("exit"))
        {
            try{ReadThread t = new ReadThread(data);
            t.run();
            t.join();}
        catch(NullPointerException e){}}


    r.close();


}

    public static class ReadThread extends Thread {
        String fileName;
        HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
        Integer symbol;

        public ReadThread(String fileName) throws IOException
        {
            this.fileName=fileName;}
        public void run(){
            FileInputStream r1 = null;
            try
            {
                r1 = new FileInputStream(this.fileName);
            }
            catch (Exception e)
            {

            }
            try
            {
                while(r1.available()>0){
                    symbol=  r1.read();

                    if(map.containsKey(symbol)){
                        map.put(symbol,map.get(symbol)+1);
                    }
                    else
                        map.put(symbol,1);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                r1.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            int maximum=1;
            HashMap <String,Integer>resultMap=new HashMap<String, Integer>();
            {
            }
            for(Map.Entry e:map.entrySet()){
                if((Integer)e.getValue()>=maximum){
                    resultMap.put(fileName, (Integer) e.getKey());
                    maximum=(Integer)e.getValue();}
                }
            System.out.println(resultMap.entrySet());
            }


        }
    }

