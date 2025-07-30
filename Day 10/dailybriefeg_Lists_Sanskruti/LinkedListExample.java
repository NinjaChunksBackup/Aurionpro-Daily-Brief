package com.aurionpro.dailybriefeg;
import java.util.LinkedList;

public class LinkedListExample 
{
    public static void main(String[] args) 
    {
        LinkedList<String> list = new LinkedList<>();

        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");

        list.remove("Tuesday");

        System.out.println("Days:");
        for (String day : list) 
        {
            System.out.println(day);
        }
    }
}
