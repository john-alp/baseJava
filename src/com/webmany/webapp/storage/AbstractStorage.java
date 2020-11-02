package com.webmany.webapp.storage;

import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {    // если index меньше нуля (возвращает метод getIndex)
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateNow(index, resume);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        // return storage[index];
        return getResume(index);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
           deleteNow(index);
        }
    }

    protected abstract void updateNow(int index, Resume resume);

    protected abstract int getIndex(String uuid);

    protected abstract Resume getResume(int index);

    protected abstract void deleteNow(int index);
}
