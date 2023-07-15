package com.StringCrud.models;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    public String name;

    public Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", age=" + age;
    }
}