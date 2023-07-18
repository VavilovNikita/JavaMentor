package com.StringCrud;

import com.StringCrud.models.Command;
import com.StringCrud.models.CommandType;
import com.StringCrud.models.Person;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestService {

    private static final Person PERSON_1 = new Person("Bob", 19);
    private static final Person PERSON_2 = new Person("Alice", 21);

    @Test
    void shouldCreateNewValueWhenExecutingCreateCommand() {
        //given
        Command command = new Command(CommandType.CREATE, PERSON_2);
        Storage storage = new Storage(new HashMap<>());
        Service service = new Service(storage);

        //when
        service.execute(command);

        //then
        Map<Integer, Person> result = storage.getMap();
        assertEquals(1, result.size());
        assertEquals(PERSON_2, result.get(1));
    }

    @Test
    void shouldUpdateValueWhenExecutingUpdateCommand() {
        //given
        Storage storage = new Storage(Map.of(1, PERSON_2));
        Command command = new Command(CommandType.UPDATE, 1, PERSON_1);
        Service service = new Service(storage);

        //when
        service.execute(command);

        //then
        Map<Integer, Person> result = storage.getMap();
        assertEquals(1, result.size());
        assertEquals(PERSON_1, result.get(1));
    }

    @Test
    void shouldDeleteValueWhenExecutingDeleteCommand() {
        //given
        Storage storage = new Storage(Map.of(1, PERSON_1));
        Command command = new Command(CommandType.DELETE, 1);
        Service service = new Service(storage);

        //when
        service.execute(command);

        //then
        assertTrue(storage.getMap().isEmpty());
    }

}