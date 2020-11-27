package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage<Integer> {
    private final List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        list.set(searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        list.add(resume);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get(searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        list.remove((searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> doCopyAll() {

        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }


}
