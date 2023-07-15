package com.StringCrud;

import com.StringCrud.models.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {


    private final HashMap<Integer, Person> map;
    private final AtomicInteger id;

    public Storage(Map<Integer, Person> map) {
        this.map = new HashMap<>(map);
        Integer lastId = map.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        id = new AtomicInteger(lastId);
    }

    public Person get(Integer id) {
        return map.get(id);
    }

    public Integer create(Person person) {
        id.incrementAndGet();
        map.put(id.get(), person);
        return id.get();
    }

    public void update(Integer id, Person newPerson) {
        map.replace(id, newPerson);
    }

    public void delete(Integer id) {
        map.remove(id);
    }

    public HashMap<Integer, Person> getMap() {
        return new HashMap<>(map);
    }

}