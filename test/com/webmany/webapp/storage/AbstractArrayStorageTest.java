package com.webmany.webapp.storage;

import com.webmany.webapp.exception.StorageException;
import com.webmany.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
 public AbstractArrayStorageTest(Storage storage) {
     super(storage);
 }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }

}