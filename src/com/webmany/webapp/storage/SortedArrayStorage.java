package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;
import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index -1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index , numMoved);
        }
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        //      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -index -1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = resume;
    }
    /*
    *  getIndex - сохраняем наш обьект Резюме.
    *  Массив не отсортированный, если запрашиваемый элемент не найден, то возвращается не просто отрицательное число,
    *  а конкретный индекс, где это элемент должен быть.
    */
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
