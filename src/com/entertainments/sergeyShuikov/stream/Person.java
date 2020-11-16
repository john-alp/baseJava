package com.entertainments.sergeyShuikov.stream;

public class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }

}
