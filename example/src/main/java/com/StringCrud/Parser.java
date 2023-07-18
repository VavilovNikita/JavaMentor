package com.StringCrud;

import com.StringCrud.models.Command;
import com.StringCrud.models.CommandType;
import com.StringCrud.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse(String command) {

        List<String> args = Arrays.asList(command.split(" "));
        validator.validate(command);

        switch (args.get(0).toUpperCase()) {
            case "GET" -> {
                return parseGet(args);
            }
            case "CREATE" -> {
                return parseCreate(args);
            }
            case "UPDATE" -> {
                return parseUpdate(args);
            }
            case "DELETE" -> {
                return parseDelete(args);
            }
            default -> throw new IllegalArgumentException("Invalid command");
        }
    }

    private Command parseCreate(List<String> args) {
        try {
            return new Command(CommandType.CREATE, objectMapper.readValue(args.get(1), Person.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Command parseGet(List<String> args) {
        return args.size() == 1
                ? new Command(CommandType.GET_ALL)
                : new Command(CommandType.GET, Integer.parseInt(args.get(1)));
    }

    private Command parseUpdate(List<String> args) {
        int id = Integer.parseInt(args.get(1));
        Person person;
        try {
            person = objectMapper.readValue(args.get(2), Person.class);
            return new Command(CommandType.UPDATE, id, person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Command parseDelete(List<String> args) {
        int id = Integer.parseInt(args.get(1));
        return new Command(CommandType.DELETE, id);
    }

}