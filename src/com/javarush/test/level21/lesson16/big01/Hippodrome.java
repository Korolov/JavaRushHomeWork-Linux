package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by alexander on 16.12.15.
 */
public class Hippodrome
{


    public ArrayList<Horse>horses=new ArrayList<Horse>();
    public static Hippodrome game;
    public ArrayList<Horse> getHorses(){
        return horses;
    }
    public static void main(String[]args) throws InterruptedException
    {

       game=new Hippodrome();
        Horse rezvaia=new Horse("Rezvaia",3,0);
        Horse bystraia=new Horse("Bystraia",3,0);
        Horse meteor=new Horse("Meteor",3,0);
        game.getHorses().add(new Horse("Rezvaia",3,0));
        game.getHorses().add(new Horse("Bystraia",3,0));
        game.getHorses().add(new Horse("Meteor",3,0));
        game.run();
        game.printWinner();


    }

    public void run() throws InterruptedException
    {
        for(int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(50);
        }

    }

    public void move(){
        for(Horse horse:horses){
            horse.move();
        }

    }

    public void print(){
        for(Horse horse:horses){
            horse.print();
        }
        System.out.println();
        System.out.println();

    }

    public Horse getWinner(){
       double max=0;
        Horse winner=null;
        for(Horse horse:horses){
            if(horse.distance>max){
                max=horse.distance;
                winner=horse;
            }

        }
        return winner;
    }


    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");

    }
}
