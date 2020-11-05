package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStorage extends AbstractStorage {
    Map<Integer, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {

    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        return null;
    }

    @Override
    public void save(Resume resume) {
        if(map.containsValue(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        map.put(map.size(), resume);
        }



    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[map.size()];
        for(int i = 0; i < map.size(); i++) {
            resumes[i] = map.get(i);
        }
        return resumes;
    }

    @Override
    public int size() {
        return map.size();
    }



}
