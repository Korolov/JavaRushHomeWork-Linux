package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;


/**
 * Created by alexander on 28.03.16.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

        boolean isDataCorrect = false;
        boolean isOperation = false;
        int amount = 0;
        do
        {
            do
            {
                try
                {
                    ConsoleHelper.writeMessage(res.getString("specify.amount"));
                    amount = Integer.parseInt(ConsoleHelper.readString());
                    if (manipulator.isAmountAvailable(amount))
                    {
                        isDataCorrect = true;
                    }
                    else
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));

                }
                catch (NumberFormatException e)
                {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));

                }
            }
            while (isDataCorrect == false);
            try
            {
               ConsoleHelper.writeMessage(res.getString("before"));
                manipulator.withdrawAmount(amount);
                isOperation = true;
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),amount,manipulator.getCurrencyCode()));
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
        while (isOperation==false);
    }


    }
