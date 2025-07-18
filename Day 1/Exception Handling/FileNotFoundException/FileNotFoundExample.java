package com.aurionpro.filenotfound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundExample {

    public static void main(String[] args) {
        File file = new File("example.txt");

        try {
            readFile(file); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) throws Exception {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
