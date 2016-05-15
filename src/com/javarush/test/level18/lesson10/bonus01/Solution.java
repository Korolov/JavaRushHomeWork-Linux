package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/



import java.io.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File fileOutput=new File(args[2]);
        File fileInput=new File(args[1]);
        if(args[0].equals("-e")){
            Encode(fileInput,fileOutput);
        }
        else if(args[0].equals("-d")){
            Decode(fileInput,fileOutput);
        }
    }
     public static void Encode(File f1, File f2) throws IOException
    {
        FileInputStream bytesStream = new FileInputStream(f1);
        byte[] bytes = new byte[bytesStream.available()];
        bytesStream.read(bytes);
        bytesStream.close();
        int count=0;
        byte[]encoded=new byte[bytes.length];
        for (byte i : bytes)
        {
            encoded[count]= (byte) (i*2);
            count++;
        }
       FileOutputStream out=new FileOutputStream(f2);
        out.write(encoded);
        out.close();
    }

    public static void Decode(File f1, File f2) throws IOException
    {
        FileInputStream bytesStream = new FileInputStream(f1);
        byte[] bytes = new byte[bytesStream.available()];
        bytesStream.read(bytes);
        bytesStream.close();
       int count=0;
        byte[]decoded=new byte[bytes.length];

        for (byte i : bytes)
        {
            decoded[count]=(byte)(i/2);
            count++;
        }

        FileOutputStream out=new FileOutputStream(f2);
        out.write(decoded);
        out.close();

                }



    }


