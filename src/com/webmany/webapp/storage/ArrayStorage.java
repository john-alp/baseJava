package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public boolean checkObject(Resume resume) {
        for (int i = 0; i < size; i++) {
            if(resume.getUuid().equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkString(String check) {
        if(size == 0) {
            //  System.out.println("Storage is empty! ");
            return false;
        } else if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (check.equals(storage[i].getUuid())) {
                    return true;
                }
            }
        }
        return false;
    }


    private int getIndex(String uuid) {
        for(int i = 0; i < size; i++) {
            if(uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        if(size <= storage.length) {    // проверяем на переполненность хранилища
            if(getIndex(resume.getUuid()) == -1 ) {  // проверяем на дубликат
                storage[size] = resume;  // кладем резюме в хранилище
                size++;
                System.out.println("Saved successfully :) ");
            } else {   // Дубликат!
                System.out.println();
                System.out.println("A duplicate is found! Not saved!! ");
            }
        } else {  // Хранилище переполненно, более 10000 записей
            System.out.println("Storage overload! ");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(index == -1) {  // -1 нет совпадений
            System.out.println("Resume (" + resume.getUuid() + ") not exist");
            System.out.println();
        } else {
            storage[index] = resume;
            System.out.println("Update (" + resume.getUuid() + ") success!");
            System.out.println();
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(index != -1) {
            return storage[index];
        } else {
            System.out.println();
            System.out.println("There is (" + uuid + ") no such resume! ");
            System.out.println();
        }
        return null;
    }

        public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index != -1) { //
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println();
            System.out.println("Delete (" + uuid + ") successfully! ");
        } else {
            System.out.println();
            System.out.println("There is (" + uuid + ") no such resume! ");
        }
    }

        /**
         * @return array, contains only Resumes in storage (without null)
         */

        public Resume[] getAll() {
           return Arrays.copyOf(storage,size);
        }

        public int size() {
            return size;
        }
    }
