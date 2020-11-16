package com.webmany.webapp.storage;

import com.webmany.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest{
    public MapStorageTest() {
        super(new MapStorage());
    }
}