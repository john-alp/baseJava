package com.entertainments.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    private class TestObject{
        String text = "";
        public TestObject(String text){
            this.text = text;
        };
        public String getText(){
            return this.text;
        }
        public void setText(String text){
            this.text = text;
        }
    }
    public Test() {
    }
    public static void main(String[] args) {
        Test test = new Test();
        TestObject testObject = null;
        HashMap hashMap = new HashMap();
        hashMap.put("Key1",test.new TestObject("Value 1"));
        hashMap.put("Key2",test.new TestObject("Value 2"));
        hashMap.put("Key3",test.new TestObject("Value 3"));
        testObject = (TestObject) hashMap.get("Key1");  // may
        System.out.println("Object value for Key1 = " + testObject.getText() + "\n");
        System.out.println("Iteration over entrySet");

        Map.Entry entry = null;
        Iterator iterator = hashMap.entrySet().iterator();
        // Итератор для перебора всех точек входа в Map
        while(iterator.hasNext()){
            entry = (Map.Entry)iterator.next();
            System.out.println("For key = " + entry.getKey() +
                    " value = " + ((TestObject)entry.getValue()).getText());
        }
        System.out.println();
        System.out.println("Iteration over keySet");
        String key = "";
        // Итератор для перебора всех ключей в Map
        iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            key = (String)iterator.next();
            System.out.println( "For key = " + key + " value = " +
                    ((TestObject)hashMap.get(key)).getText());
        }
    }
}
