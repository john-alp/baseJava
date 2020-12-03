package com.webmany.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args)  {
        // String may = "C:\\project\\basejava\\.gitignore";
        //String may = "C:/project/basejava/.gitignore";
        String filePath = "./.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        String testFile = "C:/project/basejava/src/com/webmany/webapp";
        String testFile2 = "C:/";
        File dir = new File(testFile2);
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if(list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
        System.out.println(fileInputStream.read());
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
