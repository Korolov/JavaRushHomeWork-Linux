package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;



import java.io.IOException;



/**
 * Created by alexander on 15.05.16.
 */
public class Aggregator
{
    public static void main(String[] args) throws IOException
    {

        Provider provider1=new Provider(new MoikrugStrategy());
        Provider provider=new Provider(new HHStrategy());
        HtmlView view=new HtmlView();
        Model model=new Model(view,provider,provider1);
        Controller controller=new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();






    }
}


