package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;

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

    public Boolean checkObject(Resume resume) {
        for (int i = 0; i < size; i++) {
            if(resume.getUuid().equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkString(String check) {
        if(size == 0) {
            //  System.out.println("Storage is empty! ");
            return false;
        } else if (size > 0) {
            for (int i = 0; i < size; i++) {
                //   if(storage[i].getUuid().equals(check)) {
                if (check.equals(storage[i].getUuid())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void save(Resume r) {
        if(size <= 10000) {
            if(!checkObject(r)) {
                for(int i = 0; i < storage.length; i++) {
                    if(storage[i] == null) {
                        storage[i] = r;
                        size++;
                        break;
                    }
                }
            } else {
                System.out.println();
                System.out.println("A duplicate is found! ");
            }
        } else {
            System.out.println("Storage overload! ");
        }
    }

    public void update(Resume resume) {
        for (int i = 0; i < size ; i++) {
            if(resume.getUuid().equals(storage[i].getUuid())) {
                storage[i] = resume;
                System.out.println("update " + storage[i] + " success!");
                System.out.println();
                break;
            } else {
                System.out.println("Nothing to update! ");
                System.out.println();
            }
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;

        if(checkString(uuid)) {
            for (int i = 0; i < size; i++) {
//                if (storage[i].getUuid().equals(uuid)) {
                if(uuid.toLowerCase().equals(storage[i].getUuid())) {
                    resume = storage[i];
                    break;
                }
            }
        } else {
            System.out.println();
            System.out.println("There is no such resume! ");
            System.out.println();
        }
        return resume;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                if (i == size - 1) {
                    storage[i] = null;
                } else {
                    for (int j = i; j < size - 1; j++) {
                        storage[j] = storage[j + 1];
                    }
                }
            }
        }
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] temp = new Resume[size];
        for (int i = 0; i < size; i++) {
            temp[i] = storage[i];
        }
        return temp;
    }

    public int size() {
        return size;
    }
}
