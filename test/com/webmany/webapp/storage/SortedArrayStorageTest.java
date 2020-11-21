package com.webmany.webapp.storage;

import com.webmany.webapp.exception.NotExistStorageException;
import com.webmany.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }
}