package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;
import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    protected void addSave(Resume resume) {
        int index = -(getIndex(resume.getUuid())) - 1;
        System.out.println(resume.getUuid() + " " + getIndex(resume.getUuid()) + " index " + index);
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;

//        System.arrayCopy(from, fromIndex, to, toIndex, count);
//
//        storage       - массив, который копируем
//        storage2      - массив в которой копируем
//        index         - индекс в массиве from начиная с которого берем элементы для копирования
//        index + 1     - индекс в массиве to начиная с которого вставляем элементы
//        size - index  - количество элементов которые берем из массива from и вставляем в массив to
//        Массив to должен иметь достаточный размер, чтобы в нем уместились все копируемые элементы.

    }

    protected int getIndex(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }

}
