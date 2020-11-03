package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.exception.StorageException;
import com.webmany.webapp.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "Daria";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "John";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "Tatiana";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "Barsik";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    public AbstractStorageTest(Storage storage) {  // protected - этот конструктор могут вызывать только наследники
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }




    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test

    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void notExistUpdate() throws Exception {
        storage.get("May");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = storage.getAll();    // создаем массив и копируем в него наш storage
        assertEquals(3, storage.size());  // должно быть 3 элемента
        assertEquals(RESUME_1, resumes[0]);
        assertEquals(RESUME_2, resumes[1]);
        assertEquals(RESUME_3, resumes[2]);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(RESUME_4.getUuid())); // наверное, такое возможно из-за переопределенного equals
//        Resume resume = new Resume("Test");
//        storage.save(resume);
//        Assert.assertSame(resume, storage.get("Test")); // assertSame - ожидаемый и полученный объекты это один и тот же объект.

    }

    @Test(expected = ExistStorageException.class)  // здесь ожидаем ексепшенс о существующем обьекте
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }



    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);  // запрашиваем удаленный обьект по уиду, так как он удален получаем ексепшен
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, storage.get(RESUME_1.getUuid()));
        assertEquals(RESUME_2, storage.get(RESUME_2.getUuid()));
        assertEquals(RESUME_3, storage.get(RESUME_3.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("May");
    }
}