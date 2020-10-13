package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage implements Storage{
    private final int SIZE_STORAGE = 10_000;
    private Resume[] storage = new Resume[SIZE_STORAGE];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage,0,size,null);
        size = 0;
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
        if(size <= storage.length) {                  // проверяем на переполненность хранилища
            if(getIndex(resume.getUuid()) == -1 ) {   // проверяем на дубликат
                storage[size] = resume;               // кладем резюме в хранилище
                size++;
                System.out.println("Saved successfully :) ");
            } else {                                    // Дубликат!
                System.out.println();
                System.out.println("A duplicate is found! Not saved!! ");
            }
        } else {                                        // Хранилище переполненно, более 10000 записей
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
        if(index != -1) {
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
