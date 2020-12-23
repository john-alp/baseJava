package com.entertainments.model;

import java.io.*;

public class HW09 {
//    protected static final File STORAGE_DIR2 = new File("../com/webmany/webapp/storage/storage");
    protected static final File STORAGE_DIR2 =
        new File("C:\\project\\basejava\\src\\com\\webmany\\webapp\\storage\\storage");

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(STORAGE_DIR2)){
            doWrite("May!", fos);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected static void doWrite(String resume, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }
}
