package com.webmany.webapp.storage;


import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.exception.StorageException;
import com.webmany.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
/*
*   шаблонные методы - это методы, которые имеют общий код и при этом часть своей реализации делегируют наследникам
    save, delete, update, get
* */

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected final static int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {      // удалям все данные из хранилища
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void updateNow(int index, Resume resume) {
        storage[index] = resume;
        System.out.println("Update '" + storage[index] + "' is completed");
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());  // с помощью getIndex получаем положительное целое число, которое указывает на то что этот обьект существует и где находится.
        if (index >= 0) {                       //  отрицательно число - обьект не найдет, а число показывает где бы он мог находиться.
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {     // проверка на переполняемость хранилища
            System.out.println("Storage is full");
            throw new StorageException("Storage is full", resume.getUuid());
        } else {
            insertElement(resume, index);       //  вставляем (сохраняем) элемент
            size++;
        }
    }

//    public Resume get(String uuid) {
//        int index = getIndex(uuid);
//        if (index < 0) {
//            throw new NotExistStorageException(uuid);
//        }
//        return storage[index];
//    }


    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

  //  @Override
    protected void deleteNow(int index) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);  // возвращаем копию storage
    }

    public int size() {       // возвращаем размер массива
        return size;
    }


    //protected int getIndex(String uuid);


    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);


}