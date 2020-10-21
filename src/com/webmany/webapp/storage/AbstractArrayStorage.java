package com.webmany.webapp.storage;


import com.webmany.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    protected final static int STORAGE_LIMIT = 100_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Have no this resume '" + uuid + "'");

        }
        return null;
    }

    /**
     * This method should check whether the object is already in storage
     */
    protected abstract int getIndex(String uuid);


    public void save(Resume resume) {
        if (size >= storage.length) {
            System.out.println("Storage is full");
        } else {
            int index = getIndex(resume.getUuid());
            if (index > 0) {
                System.out.println("This resume '" + resume.getUuid() +"' is already exists");
            } else {
                 addSave(resume);
                 size++;
            }
        }
    }

    protected abstract void addSave(Resume resume);


    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Have no this resume '" + resume.getUuid() + "' to update");
        } else {
            storage[index] = resume;
            System.out.println("Update '" + storage[index] + "' is completed");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            if (size - 1 - index >= 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            }
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Have no this resume '" + uuid + "' to delete");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}