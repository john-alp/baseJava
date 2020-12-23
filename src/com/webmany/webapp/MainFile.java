package com.webmany.webapp;


import com.webmany.webapp.model.Resume;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFile {
    public static void main(String[] args) throws IOException {
        //   String path = "./src/.";
        final String path = "./com/webmany/webapp/storage/storage";
        String dir = "./src/.";
        //recurs(path);
        //printDirectoryDeeply(new File(dir));



    }




    private static void recurs(String path) {
        File dir = new File(path);

        System.out.println((!dir.isDirectory() ? "    - " : "") + dir.getName());

        if (dir.isDirectory()) {
            File[] list = dir.listFiles();
            if (list != null)
                for (File name : list)
                    recurs(name.getPath());
        }
    }

    // another solution
    @Nullable
//    @NotNull
    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }



        /*     // String may = "C:\\project\\basejava\\.gitignore";
        //String may = "C:/project/basejava/.gitignore";
        //String filePath = "./.gitignore";
       // String filePath = "C:\\project\\basejava\\src\\com\\webmany\\webapp\\MainArray";

        String filePath = "./storaga";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalFile() + " Kroko");
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        // String testFile = "C:/project/basejava/src/com/webmany/webapp";
        String testFile = "./";
        File dir = new File(testFile);
        // System.out.println(dir.list() + " may");

        String[] list = dir.list();
        List<String> stringList = new ArrayList<>();
        stringList = Arrays.asList(dir.list());
        if(list != null) {
            for (String name : stringList) {
                System.out.println(name);
            }
        }
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
        System.out.println(fileInputStream.read());
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    */
}
