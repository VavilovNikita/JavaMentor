package com.StringCrud;

import com.StringCrud.models.Command;
import com.StringCrud.models.CommandType;
import com.StringCrud.models.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestParser {


    private final Validator validator = new Validator();
    private final Parser parser = new Parser(validator);

    private static final String PERSON_JSON_STRING = "{\"name\":\"Bob\",\"age\":19}";
    private static final Person PERSON = new Person("Bob", 19);


    @Test
    void parseGetAllTest() {
        String commandString = "GET";
        Command result = parser.parse(commandString);

        assertEquals(CommandType.GET_ALL, result.getCommandType());
        assertNull(result.getPerson());
        assertNull(result.getId());
    }

    @Test
    void parseGetByIdTest() {
        String commandString = "GET 1";
        Command result = parser.parse(commandString);

        assertEquals(CommandType.GET, result.getCommandType());
        assertNull(result.getPerson());
        assertEquals(1, result.getId());
    }

    @Test
    void parseCreateTest() {
        String commandString = "CREATE " + PERSON_JSON_STRING;
        Command result = parser.parse(commandString);

        assertEquals(CommandType.CREATE, result.getCommandType());
        assertEquals(PERSON, result.getPerson());
        assertNull(result.getId());
    }

    @Test
    void parseUpdateTest() {
        String commandString = "UPDATE 1 " + PERSON_JSON_STRING;
        Command result = parser.parse(commandString);

        assertEquals(CommandType.UPDATE, result.getCommandType());
        assertEquals(PERSON, result.getPerson());
        assertEquals(1, result.getId());
    }

    @Test
    void parseDeleteTest() {
        String commandString = "DELETE 123";
        Command result = parser.parse(commandString);

        assertEquals(CommandType.DELETE, result.getCommandType());
        assertNull(result.getPerson());
        assertEquals(123, result.getId());
    }
}