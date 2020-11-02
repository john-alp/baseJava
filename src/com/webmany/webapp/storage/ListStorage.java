package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;




public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void save(Resume resume) {
        if (list.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            list.add(resume);
        }
    }

    @Override
    protected Resume getResume(int index) {
        return list.get(index);
        }

        @Override
    protected void deleteNow(int index) {
        list.remove(index);
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            resumes[i] = list.get(i);
        }
        return resumes;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void updateNow(int index, Resume resume) {
        list.add(index, resume);
    }

    @Override
    protected int getIndex(String uuid) {   // что странно, что хватило стринга
        Resume resume = new Resume(uuid);
        return list.indexOf(resume);
    }
}
