package com.filesystems;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) {

        try {
            // Step 1: Create FileReader object
            
            //Step 3: Write into file
            
            FileWriter fw = new FileWriter("C:\\Users\\SMK5\\Downloads\\SampleText.txt", true);
            fw.write("\nThis is a new line added to the file.");
            fw.close();
            
            FileReader fr = new FileReader
            		  ("C:\\Users\\SMK5\\Downloads\\SampleText.txt");
            		            int i;   
            		            System.out.println("Reading data from file:");
            		            // Step 2: Read character by character
            		            while((i = fr.read()) != -1) {
            		                System.out.print((char)i);
            		            }
            		            fr.close();
            
            
        }
        catch(IOException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}

