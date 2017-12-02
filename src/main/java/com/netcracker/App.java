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

        File dir = new File(inputDirectory);

        System.out.println("Files:");
        List<String> list = FileManager.processAllFilesFromDirectory(dir);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("Count:");
        Map<String,Integer> map = FileManager.countOfFiles();
        for(Map.Entry<String, Integer> i: map.entrySet()){
            int value = i.getValue();
            String key = i.getKey();
            System.out.println("Extension: " + key + ", count: " + value);

        }


    }
}
