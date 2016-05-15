package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Alexander on 22.12.2015.
 */
public class Snake
{
    private ArrayList<SnakeSection> sections;
    private Boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x,int y){
        sections=new ArrayList<SnakeSection>();
        sections.add(0,new SnakeSection(x,y));
        isAlive=true;
    }

    public boolean isAlive()
    {
        return isAlive;
    }





    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    int getX(){
        return sections.get(0).getX();
    }

    int getY(){
        return sections.get(0).getY();
    }
    public void move(){

    }

}
