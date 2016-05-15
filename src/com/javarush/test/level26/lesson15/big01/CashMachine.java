package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.command.LoginCommand;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by alexander on 28.03.16.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[]args) throws IOException, InterruptOperationException
    {
        Locale.setDefault(Locale.ENGLISH);





        try{CommandExecutor.execute(Operation.LOGIN);}
        catch (Exception e){

        }
            try
            {

                Operation operation;
                do
                {
                operation=ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
                }
                while (operation!=Operation.EXIT);

            }
            catch (InterruptOperationException e)
            {

                try
                {
                    CommandExecutor.execute(Operation.EXIT);
                }
                catch (InterruptOperationException ignored)
                {
                    ConsoleHelper.printExitMessage();
                }
            }








    }
}
