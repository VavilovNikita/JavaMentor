package com.StringCrud;

import com.StringCrud.models.Person;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStorage {

    private static final Person PERSON_1 = new Person("Bob", 19);
    private static final Person PERSON_2 = new Person("Alice", 21);

    @Test
    void getAllTest() {
        Map<Integer,Person> map = Map.of(
                1, PERSON_1,
                2, PERSON_2
        );

        Storage storage = new Storage(map);
        Map<Integer, Person> result = storage.getMap();

        assertEquals(2, result.size());
        assertEquals(PERSON_1, map.get(1));
        assertEquals(PERSON_2, map.get(2));
    }

    @Test
    void getTest() {
        Map<Integer,Person> map = Map.of(
                1, PERSON_1,
                2, PERSON_2
        );
        Storage storage = new Storage(map);
        Person result = storage.get(1);

        assertEquals(PERSON_1, result);
    }

    @Test
    void createTest() {
        Storage storage = new Storage(new HashMap<>());
        storage.create(PERSON_1);

        Map<Integer, Person> result = storage.getMap();

        assertEquals(1, result.size());
        assertEquals(PERSON_1, result.get(1));
    }

    @Test
    void updateTest() {
        Map<Integer, Person> map = Map.of(1, PERSON_1);
        Storage storage = new Storage(map);

        storage.update(1, PERSON_2);

        Map<Integer, Person> result = storage.getMap();

        assertEquals(1, result.size());
        assertEquals(PERSON_2, result.get(1));
    }

    @Test
    void deleteTest() {
        Map<Integer, Person> map = Map.of(1, PERSON_1);
        Storage storage = new Storage(map);

        storage.delete(1);

        assertTrue(storage.getMap().isEmpty());
    }



}