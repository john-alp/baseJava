package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapUuidStorageTest extends AbstractStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }
//    @Test
//    @Override
//    public void getAll() throws Exception {
//        List<Resume> resumes = storage.getAllSorted();    // создаем массив и копируем в него наш storage
//        assertEquals(3, storage.size());  // должно быть 3 элемента
//        assertEquals(new Resume("Daria", "Daria" ), resumes[0]);
//    }
}
