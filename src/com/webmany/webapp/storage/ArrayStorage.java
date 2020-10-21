package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    protected void addSave (Resume resume) {
        System.out.println("I am stay ArrayStorage");
        storage[size] = resume;
        size++;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}