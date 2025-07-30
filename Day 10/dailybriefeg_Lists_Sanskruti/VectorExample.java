package com.aurionpro.dailybriefeg;
import java.util.Vector;

public class VectorExample 
{
    public static void main(String[] args) 
    {
        Vector<String> vector = new Vector<>();

        vector.add("Red");
        vector.add("Green");
        vector.add("Blue");

        vector.remove(1); 

        System.out.println("Colors in vector:");
        for (String color : vector)
        {
            System.out.println(color);
        }
    }
}
