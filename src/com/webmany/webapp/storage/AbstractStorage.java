 package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


 public abstract class AbstractStorage<SK> implements Storage {

     private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

     protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

     protected abstract List<Resume> doCopyAll();


     public void update(Resume resume) {
         LOG.info("update " + resume);
         SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        LOG.info("save" + resume);
         SK searchKey = getNotExistedSearchKey(resume.getUuid());
            doSave(resume, searchKey);
    }

    public void delete(String uuid) {
         LOG.info("delete" + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
         LOG.info("delete" + uuid);
       SK searchKey = getExistedSearchKey(uuid);
       return doGet(searchKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {   // если не существует
            LOG.warning("Resume " + uuid + " already exist");
            throw  new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw  new ExistStorageException(uuid);
        }
        return searchKey;
    }

     @Override
     public List<Resume> getAllSorted() {
         LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
         Collections.sort(list);
         return list;
     }
 }
