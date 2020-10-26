package com.webmany.webapp.storage;

import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// import static org.junit.Assert.*;

public class SortedArrayStorageTest {
    private Storage storage = new SortedArrayStorage();

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
       storage.clear();
        Assert.assertEquals(0,storage.size());
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.clear();
        Resume resume = new Resume("Test");
        storage.save(resume);
        Assert.assertSame(resume, storage.get("Test")); // assertSame - ожидаемый и полученный объекты это один и тот же объект.
    }

    @Test
    public void delete() throws Exception {
    storage.delete("John");
    storage.delete("Tatiana");
    storage.delete("Daria");
    Assert.assertEquals(0,storage.size());
    }

    @Test
    public void get() throws Exception {
    Assert.assertEquals(new Resume("John"),storage.get("John"));
    Assert.assertEquals(new Resume("Tatiana"), storage.get("Tatiana"));
    Assert.assertEquals(new Resume("Daria"), storage.get("Daria"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("May");
    }

}