package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;

import java.util.List;

/**
 * Created by alexander on 16.05.16.
 */
public class HtmlView implements View
{
    Controller controller;
    private final String filePath= "./src/"+this.getClass().getPackage().getName().replace(".","/")+"/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies)
    {

try{
        updateFile(getUpdatedFileContent(vacancies));}
catch (Exception e){
    e.printStackTrace();
}
    }
     private String getUpdatedFileContent(List<Vacancy> list){
         return null;
     }

    private void updateFile(String string){

    }




    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException
    {
        controller.onCitySelect("Odessa");


    }
}
