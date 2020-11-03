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
    public void save(Resume resume) {
        if(map.containsValue(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        map.put(map.size(), resume);
        }

    @Override
    protected Resume getResume(int index) {
        return map.get(index);
    }

    @Override
    protected void deleteNow(int index) {
        map.remove(index);
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

    @Override
    protected void updateNow(int index, Resume resume) {
        map.put(index, resume);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        Set<Map.Entry<Integer,Resume>> entrySet = map.entrySet(); // entrySet() возвращает набор ключ-значений
        for (Map.Entry<Integer, Resume> pair : entrySet) {
            if (resume.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return -1;
    }
}
