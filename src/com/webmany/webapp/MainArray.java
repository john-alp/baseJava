package com.webmany.webapp;

import com.webmany.webapp.model.Organization;
import com.webmany.webapp.model.Resume;
import com.webmany.webapp.storage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;


/**
 * Interactive test for ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
//    private final static Storage ARRAY_STORAGE = new SortedArrayStorage();
//    private final static Storage ARRAY_STORAGE = new ListStorage();
    private final static Storage ARRAY_STORAGE = new MapUuidStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;
        char[] alphabetA = ("acderstxyz").toCharArray();
        for (int i = 0; i < alphabetA.length; i++) {
            resume = new Resume(String.valueOf(alphabetA[i]), "TestName" + i);
            ARRAY_STORAGE.save(resume);
        }
        printAll();


        while (true) {
            System.out.print("Введите одну из команд - (list | save fullName | update uuid and fullName| delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length >1) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    resume = new Resume(param, params[2]);
                    ARRAY_STORAGE.save(resume);
                    break;
                case "update":
                    resume = new Resume(param, params[2]);
                    ARRAY_STORAGE.update(resume);
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(param);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(param));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда2.");
                    break;
            }
        }
    }

    static void printAll() {
        List<Resume> all = ARRAY_STORAGE.getAllSorted();
        System.out.println("----------------------------");
        if (all.size() == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}