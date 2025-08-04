package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class ToDoListExample 
{
    public static void main(String[] args) 
    {
        
        List<String> toDoList = new ArrayList<>();

        // Add tasks 
        toDoList.add("Wake up");
        toDoList.add("Brush teeth");
        toDoList.add("Have breakfast");
        toDoList.add("Go to work");

       
        System.out.println("Your tasks for today:");
        for (String task : toDoList) 
        {
            System.out.println("- " + task);
        }

        
        toDoList.remove(2); 

        System.out.println("\nDon't forget to: " + toDoList.get(1));

        System.out.println("\nTotal tasks: " + toDoList.size());
    }
}
