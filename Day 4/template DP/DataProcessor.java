package com.aurionpro.model;

public abstract class DataProcessor {
	
	
	
    public final void process() {
        readData();
        processData();
        saveData();
    }
    
    abstract void readData();
    abstract void processData();

    void saveData() {
        System.out.println("Saving processed data to DB");
    }
}
