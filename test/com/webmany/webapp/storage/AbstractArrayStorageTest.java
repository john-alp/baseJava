package com.webmany.webapp.storage;

import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractArrayStorageTest {
    private Storage storage = new ArrayStorage();

    private static final String uuid_1 = "John";
    private static final String uuid_2 = "Tatiana";
    private static final String uuid_3 = "Daria";

    @Before
    public void setUp () throws Exception {
        storage.clear();
        storage.save(new Resume(uuid_1));
        storage.save(new Resume(uuid_2));
        storage.save(new Resume(uuid_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals("May",3, storage.size());
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("May");
    }
}