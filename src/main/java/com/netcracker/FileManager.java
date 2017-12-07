package com.netcracker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    private String directory;
    public static List<String> listFiles = new ArrayList<String>(); //static, чтобы хранить значения адресов файлов

    public FileManager(String directory){
        this.directory = directory;
    }

    /**
     * Получает расширение файла
     * @param mystr полное имя файла
     * @return расширение файла
     */
    public String getFileExtension(String mystr) {
        Pattern p = Pattern.compile("\\.\\w+$");
        Matcher m = p.matcher(mystr);
        String ext = "";
        while (m.find()) {
            ext = m.group();
        }
        return ext;

        /*int index = mystr.lastIndexOf('.');//indexOf('.');
        return index == -1? null : mystr.substring(index);*/
    }

    /**
     * Раскручивает папку, вытаскивает все файлы из папки и подпапок
     * @param directory адрес папки
     * @return ArrayList c полным адресом файлов
     */
    public List<String> processAllFilesFromDirectory(File directory)
    {
        for (File item : directory.listFiles())
        {
            if (item.isDirectory())
            {
                processAllFilesFromDirectory(item);
                continue;
            }
            else{
                //System.out.println(item.getPath());
                listFiles.add(item.getPath());
            }
        }
        return listFiles;
    }

    /**
     * Считает количество файлов с определенным расширением
     * @return HashMap с раширениями и их количеством (ключ-значение)
     */
    public Map<String,Integer> countOfFiles(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        String temp;
        for(int i=0; i<listFiles.size(); i++) {
            temp = listFiles.get(i);
            if (map.containsKey(getFileExtension(temp)))
                map.put(getFileExtension(temp), map.get(getFileExtension(temp)) + 1);
            else map.put(getFileExtension(temp), 1);
        }
        return map;
    }
}
