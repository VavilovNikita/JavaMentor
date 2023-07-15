package com.StringCrud;

import com.StringCrud.models.Command;
import com.StringCrud.models.Person;

import java.util.Arrays;
import java.util.List;

public class Parser {


    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse(String command) {

        List<String> args = Arrays.asList(command.split(" "));
        args.set(0, args.get(0).toUpperCase());
        validator.validate(command);

        switch (args.get(0)) {
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
        return new Command("CREATE", new Person(args.get(1), Integer.parseInt(args.get(2))));
    }

    private Command parseGet(List<String> args) {
        return args.size() == 1
                ? new Command("GET_ALL")
                : new Command("GET", Integer.parseInt(args.get(1)));
    }

    private Command parseUpdate(List<String> args) {
        int id = Integer.parseInt(args.get(1));
        Person person = new Person(args.get(2), Integer.parseInt(args.get(3)));
        return new Command("UPDATE", id, person);
    }

    private Command parseDelete(List<String> args) {
        int id = Integer.parseInt(args.get(1));
        return new Command("DELETE", id);
    }

}