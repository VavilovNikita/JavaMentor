package com.StringCrud;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestValidator {

    private final Validator validator = new Validator();
    private static final String PERSON_JSON_STRING = "{\"name\": \"Bob\", \"age\": 19}";


    @Test
    void validateGetAllTest() {
        String command = "GET";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateGetByIdTest() {
        String command = "GET 123";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateCreateTest() {
        String command = "CREATE " + PERSON_JSON_STRING;
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateUpdateTest() {
        String command = "UPDATE 12 " + PERSON_JSON_STRING;
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateDeleteTest() {
        String command = "DELETE 12";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void shouldThrowExceptionWhenValidatingEmptyString() {
        String command = "";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenValidatingNullString() {
        String command = null;
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateGetShouldThrowExceptionWhenCREATEHas3Elements() {
        String command = "GET 12 " + PERSON_JSON_STRING;
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateGetShouldThrowExceptionWhenFirstArgIsNotGET() {
        String command = "12 asd";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateGetShouldThrowExceptionWhenSecondArgIsNotInt() {
        String command = "GET asd";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateCreateShouldThrowExceptionWhenListHas1Elements() {
        String command = "CREATE";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateCreateShouldThrowExceptionWhenFirstAgrIsNotCREATE() {
        String command = "asd 123";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateUpdateShouldThrowExceptionWhenListHas2Elements() {
        String command = "UPDATE 123";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateUpdateShouldThrowExceptionWhenFirstAgrIsNotUPDATE() {
        String command = "asd 123";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateUPDATEShouldThrowExceptionWhenSecondArgIsNotInt() {
        String command = "UPDATE asd " + PERSON_JSON_STRING;
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateDeleteShouldThrowExceptionWhenListHas1Elements() {
        String command = "DELETE";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateDeleteShouldThrowExceptionWhenFirstAgrIsNotDELETE() {
        String command = "asd 123";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }

    @Test
    void validateDeleteShouldThrowExceptionWhenSecondArgIsNotInt() {
        String command = "DELETE asd";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid command entered", ex.getMessage());
    }



}