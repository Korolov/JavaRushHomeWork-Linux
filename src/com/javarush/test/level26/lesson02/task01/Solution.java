package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    static double mediana;
    public static Integer[] sort(Integer[] array) {
        Comparator<Integer>findMed=new Comparator<Integer>()
        {
            @Override
            public int compare(Integer integer, Integer t1)
            {
                return integer-t1;
            }

        };
       Arrays.sort(array,findMed);
        if(array.length%2!=0){
            mediana=array[array.length/2];
        }
        else
        mediana=(double)(array[array.length/2-1]+array[array.length/2])/2;
        Comparator<Integer>sortByMediane=new Comparator<Integer>()
        {
            @Override
            public int compare(Integer integer, Integer t1)
            {


                int result = (int)(Math.abs(integer - mediana) - Math.abs(t1 - mediana));
                return result==0?integer-t1:result;

            }
        };


        Arrays.sort(array,sortByMediane);




        //implement logic here
        return array;
    }
    public static void main(String[]args){
        Integer[]list=new Integer[]{1,2,3,4,5};
        sort(list);
        System.out.print("[");
        for(Integer e:list){
            System.out.print(" "+e);
        }
        System.out.println("]");
        System.out.println(mediana);
    }
}
