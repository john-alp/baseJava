 package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract Integer getSearchKey(String uuid);



    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }
    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
            doSave(resume, searchKey);
    }

    /* в Object присваеваем String? */

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
       Object searchKey = getExistedSearchKey(uuid);
       return doGet(searchKey);
    }

/*
    если обьект существует, то возвращаем Object searchKey
    иначе бросаем NotExistStorageException

 */
    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {   // если не существует
            throw  new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw  new ExistStorageException(uuid);
        }
        return searchKey;
    }





}
