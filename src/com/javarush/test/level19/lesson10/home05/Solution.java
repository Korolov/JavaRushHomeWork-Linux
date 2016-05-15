package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer=new BufferedWriter(new FileWriter(args[1]));
        String line="";
        Pattern p=Pattern.compile("[0-9]");
        Matcher m;



        while((line=reader.readLine())!=null){
            String[]list=line.split(" ");
           for(String item:list){
               m=p.matcher(item);
               if(m.find()){
                   writer.write(item+" ");

               }
           }
        }
        writer.close();
        reader.close();
    }
}
