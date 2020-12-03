package com.webmany.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\project\\basejava\\.gitignore");
        System.out.println(file.getCanonicalFile());
    }
}
