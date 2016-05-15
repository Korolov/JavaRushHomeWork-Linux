package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/home/alexander/temp.txt",null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);


            JavaRush javaRush = new JavaRush();

            User ivanov=new User();
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            Calendar calendar=Calendar.getInstance();
            calendar.set(1987,10,03);
            ivanov.setBirthDate(new Date(calendar.getTimeInMillis()));
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.RUSSIA);
            javaRush.users.add(ivanov);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            String check=loadedObject.equals(javaRush)?"Yes":"No";

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter wr=new PrintWriter(outputStream);


            if(this.users!=null){
                for(User user:users){
                    wr.println(user.getFirstName());
                    wr.println(user.getLastName());
                    wr.println(user.getBirthDate().getTime());
                    wr.println(user.isMale());
                    wr.println(user.getCountry().getDisplayedName());}}
            wr.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

            String data="";
            while((data=reader.readLine())!=null)
            {
                User user = new User();
                user.setFirstName(data);
                user.setLastName(reader.readLine());

                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(new Boolean(reader.readLine()));
                String country=reader.readLine();
                if (country.equals("Russia"))
                    user.setCountry(User.Country.RUSSIA);
                else if (country.equals("Ukraine"))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
                this.users.add(user);
            }
            reader.close();

        }
    }
}
