package com.aurionpro.model;

public class ExcelDataProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("Reading data from Excel file");
    }

    @Override
    void processData() {
        System.out.println("Processing Excel data");
    }
}