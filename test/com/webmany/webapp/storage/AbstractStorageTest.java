package com.webmany.webapp.storage;

import com.webmany.webapp.exception.ExistStorageException;
import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("C:\\project\\basejava\\src\\com\\webmany\\webapp\\storage\\fileStorage");
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.setContacts(ContactType.MAIL, "mail1@ya.ru");
        R1.setContacts(ContactType.PHONE, "11111");
        R1.setSections(SectionType.OBJECTIVE, new TextSection("Objective1"));
         R1.setSections(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.setSections(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.setSections(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.setSections(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.setSections(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        R2.setContacts(ContactType.SKYPE, "skype2");
        R2.setContacts(ContactType.PHONE, "22222");
        R1.setSections(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://Organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
    }



    protected AbstractStorageTest(Storage storage) {  // protected - этот конструктор могут вызывать только наследники
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }


    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "NewName");
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void notExistUpdate() throws Exception {
        storage.get("May");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());  // должно быть 3 элемента
        assertEquals(list, Arrays.asList(R1, R2, R3));
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
        // assertEquals(RESUME_4, storage.get(RESUME_4.getUuid())); // наверное, такое возможно из-за переопределенного equals
    }

    @Test(expected = ExistStorageException.class)  // здесь ожидаем ексепшенс о существующем обьекте
    public void saveExist() throws Exception {
        storage.save(R1);
    }



    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);  // запрашиваем удаленный обьект по уиду, так как он удален получаем ексепшен
    }

    @Test
    public void get() throws Exception {
       assertGet(R1);
       assertGet(R2);
       assertGet(R3);
        // assertEquals(RESUME_1, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("May");
    }

    private void assertSize (int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet (Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}