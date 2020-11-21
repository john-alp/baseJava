package com.webmany.webapp;

import com.webmany.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1, "Name1");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name2");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name3");
    private static final Resume RESUME_4 = new Resume(UUID_4, "Name4");

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        Arrays.asList(RESUME_1, RESUME_2, RESUME_3);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = (Resume) iterator.next();
            System.out.println(resume);
        }
//        for (Resume resume : collection) {
//            System.out.println(resume);
//        }
        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);

    }
}