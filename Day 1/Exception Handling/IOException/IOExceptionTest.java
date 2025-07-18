package com.aurionpro.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOExceptionTest {

	    public static void main(String[] args)
	    {
	    	
	    	Path path = Path.of("samplefile.txt");
	    	String line = null;

	        try {
		    	
		       	BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		    				while((line = br.readLine()) != null) {
		    					System.out.println(line);
		    					
		    				}
	     
	        }
	        catch(IOException e) {
	        	  System.out.println("IOException caught: " + e.getMessage());
			}


	        finally {

	            System.out.println("Finally Executed");
	        }
	    }
	}


