package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static ArrayList<File>filesToSort=new ArrayList<>();


    public static void main(String[] args) throws IOException
    {

        BufferedReader reader;
        BufferedWriter writer;

        File folder=new File(args[0]);
        File resultFile=new File(args[1]);
        getFilesList(folder);
        Collections.sort(filesToSort, new Comparator<File>()
        {
            @Override
            public int compare(File file, File t1)
            {
                return -t1.compareTo(file);
            }
        });
        deleteEmptyFolders(folder);
        String result="";

        writer=new BufferedWriter(new FileWriter(resultFile));
        for(File file1:filesToSort){
            reader=new BufferedReader(new FileReader(file1));

            while (reader.ready())
                result+=reader.readLine()+"\n";
        }
        result=result.substring(0,result.length()-1);
        writer.write(result);

        writer.close();
        resultFile.renameTo(new File(resultFile.getAbsolutePath().substring(0,resultFile.getAbsolutePath().indexOf(resultFile.getName()))+"allFilesContent.txt"));


    }
    private static void getFilesList(File folder){

        for(File file:folder.listFiles()){
            if(!file.isDirectory()){
                if(file.length()>50)
                    file.delete();
                else
                    filesToSort.add(file);
            }
            else{
                getFilesList(file);
            }
        }
    }
    private static void deleteEmptyFolders(File folder){
        for(File file:folder.listFiles()){


            if(file.isDirectory()&&file.listFiles().length==0){
               file.delete();}
                else if(file.isDirectory()&&file.listFiles().length>0)
                    deleteEmptyFolders(file);
            }
    }




    }

