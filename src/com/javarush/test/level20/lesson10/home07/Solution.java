package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;
    public static void main(String[]args) throws IOException, ClassNotFoundException
    {
        Solution saved=new Solution("Moscow");
        saved.writeObject("Alexander");
        File file=File.createTempFile("/home/",null);

        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
        out.writeObject(saved);

        Solution loaded=(Solution)in.readObject();



        loaded.writeObject("Kiev");
        System.out.println(loaded.toString());

    }

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName=fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }



    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);





    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        fileName=(String)in.readObject();
        stream = new FileOutputStream(fileName,true);









    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
