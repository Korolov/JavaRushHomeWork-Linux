package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;


/**
 * Created by alexander on 28.03.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en");

    @Override
    public void execute()
    {

        {
            boolean money = false;
            ConsoleHelper.writeMessage(res.getString("before"));
            for (Object cur : CurrencyManipulatorFactory.getAllCurrencyManipulators())
            {
                if (((CurrencyManipulator) cur).hasMoney())
                {
                    if (((CurrencyManipulator) cur).getTotalAmount() > 0)
                    {
                        ConsoleHelper.writeMessage(((CurrencyManipulator) cur).getCurrencyCode() + " - " + ((CurrencyManipulator) cur).getTotalAmount());
                        money = true;
                    }
                }
            }
            if (!money)
                ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}