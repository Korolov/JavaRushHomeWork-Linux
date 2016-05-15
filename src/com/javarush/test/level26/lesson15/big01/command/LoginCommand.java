package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by alexander on 28.03.16.
 */
 public class LoginCommand implements Command
{

    private ResourceBundle validCreditCards=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");


    @Override
    public void execute() throws InterruptOperationException{


       while(true){
           ConsoleHelper.writeMessage(res.getString("specify.data"));
           String s1=ConsoleHelper.readString();
           String s2=ConsoleHelper.readString();
           if(s1.matches("^[0-9]{12}$")&&s2.matches("^[0-9]{4}$")){
                    ConsoleHelper.writeMessage(res.getString("before"));
               if(validCreditCards.containsKey(s1))
                        if (validCreditCards.getObject(s1).equals(s2)){
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),s1));
                        break;
                    }
                    else{
                            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),s1));

                        }

                }
           else
               ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
       }


    }
}
