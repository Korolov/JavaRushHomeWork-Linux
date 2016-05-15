package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            File file = File.createTempFile("/home/alexander/", null);
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            String isEqual = classWithStatic.equals(loadedObject) ? "Yes" : "No";

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic
    {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public ClassWithStatic()
        {
            this.i = i;
            this.j = j;
        }

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter wr = new PrintWriter(outputStream);
            wr.println(staticString);
            wr.println(i);
            wr.println(j);
            wr.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));



            staticString=reader.readLine();

            i = Integer.parseInt(reader.readLine());
            j = Integer.parseInt(reader.readLine());


        }


        }
    }

