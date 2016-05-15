package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by alexander on 28.03.16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");
   final static  BufferedReader READER=new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }


    public static String readString() throws InterruptOperationException
    {
        String result="";

        try{
            result=READER.readLine();
            if(result.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw new InterruptOperationException();

        }
            catch(IOException e){


            }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String s;
        writeMessage(res.getString("choose.currency.code"));
        s=readString();
        if(s.length()!=3){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
            return askCurrencyCode();
        }
        else
            return s.toUpperCase();

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String money="";
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
        try{
            money=readString();
            String a=money.split(" ")[0];
            String b=money.split(" ")[1];
            Integer.parseInt(a);
            Integer.parseInt(b);
        return  new String[]{a,b};}

        catch(ArrayIndexOutOfBoundsException e){
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currencyCode);
        }
        catch (NumberFormatException e){
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation)"));

            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));


    }


}
