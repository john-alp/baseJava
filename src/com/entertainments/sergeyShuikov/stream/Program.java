package com.entertainments.sergeyShuikov.stream;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 42));
        personList.add(new Person("Tatiana", 37));
        personList.add(new Person("Daria", 10));

//        for(Person person : personList) {
//            System.out.println(person);
//        }

//        personList.stream().forEach((Person p ) -> System.out.println(p));
        personList.stream()
                .filter(person -> {
                    return person.getAge() >= 18;
                })  //возвращает буленовское значение

//                .forEach(p -> System.out.println(p)); // убираем тип параметра и круглые скобки, так как параметр один
        .forEach(System.out::println);  // еще короче.. Одинаковые типы данных и у лямбды и принтЛн?
    }


}
