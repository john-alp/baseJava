package com.entertainments.model;

import java.io.*;

public class TextToFile {
    public static void main(String[] args){

        File file1 = new File("test1.txt");
        File file2 = new File("test2.txt");

        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(file1))) {
            bufferedWriter.write("this is test");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        try(BufferedReader bufferedReader=new BufferedReader((new FileReader(file1)));
            BufferedWriter bufferedWriter2= new BufferedWriter(new FileWriter(file2))){
            String  b;
            while ((b = bufferedReader.readLine()) != null) {
                System.out.println(b);
                bufferedWriter2.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
