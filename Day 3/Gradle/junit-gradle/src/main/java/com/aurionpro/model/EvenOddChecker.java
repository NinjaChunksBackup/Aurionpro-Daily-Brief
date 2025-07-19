package com.aurionpro.model;

public class EvenOddChecker 
{

    public String check(int number) 
    {
        if (number % 2 == 0) 
        {
            return "Even";
        } else 
        {
            return "Odd";
        }
    }

    public static void main(String[] args) 
    {
        EvenOddChecker checker = new EvenOddChecker();
        for (int i = 1; i <= 10; i++) 
        {
            System.out.println(i + " is " + checker.check(i));
        }
    }
}
