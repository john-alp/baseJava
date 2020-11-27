package com.webmany.webapp;

public class TestSingleton {
    private static TestSingleton ourInstance;

    public static TestSingleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new TestSingleton();
        }
        return ourInstance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
    }
}
