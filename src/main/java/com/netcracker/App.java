package com.netcracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input directory address:");
        String inputDirectory = reader.readLine();
        File dirFile = new File(inputDirectory);
        FileManager dir = new FileManager(inputDirectory);


        List<String> listFiles = dir.processAllFilesFromDirectory(dirFile);
        System.out.println("Files:");
        for(String s:listFiles) System.out.println(s);

        System.out.println("Count of files:");
        Map<String,Integer> map = dir.countOfFiles();
        for(Map.Entry<String, Integer> i: map.entrySet()){
            int value = i.getValue();
            String key = i.getKey();
            System.out.println("Extension: " + key + ", count: " + value);

        }

    }
}
