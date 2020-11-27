package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    Map<String, Resume> map = new HashMap<>();

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, String uuid) {
         map.put(uuid, resume);
       // map.replace((String) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
       return uuid;

        // return map.get(uuid).equals(uuid);
     /*   for (Resume tmp : map.values()) {
            if (tmp.equals(uuid)) {
                return tmp;
            }
        }
        return null;*/
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        //return Collections.emptyList();
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
