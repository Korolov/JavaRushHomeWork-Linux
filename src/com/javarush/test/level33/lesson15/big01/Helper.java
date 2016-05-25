package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;

import java.security.SecureRandom;

/**
 * Created by alexander on 25.05.16.
 */
public class Helper
{
    public static String generateRandomString()
    {
        SecureRandom sr=new SecureRandom();
        BigInteger bi=new BigInteger(100,sr);
        return bi.toString(32);
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
}
