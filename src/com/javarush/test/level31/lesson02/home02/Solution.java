package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    static ArrayList<String>allFiles=new ArrayList<>();
    public static List<String> getFileTree(String root) throws IOException {
        File file=new File(root);
        Queue<File> files=new PriorityQueue<>();

        for(File e:file.listFiles()){
            files.add(e);
            if(e.isFile())
            allFiles.add(e.getAbsolutePath());
        }
        while(!files.isEmpty()){
            if(files.element().listFiles()==null){
                files.remove();
                continue;}

            for(File e:files.element().listFiles())
            {

                files.add(e);
                if(e.isFile())
                allFiles.add(e.getAbsolutePath());}

            files.remove();
        }
        return allFiles;

    }

    public static void main(String[]args) throws IOException
    {
        System.out.println(getFileTree(Paths.get("/media/alexander/Данные/Музыка").toString()).size());
    }
}
