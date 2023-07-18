package com.StringCrud;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public void validate(String command) {
        if (command == null|| command.isEmpty()) {
            throwIllegalCommandException();
        }

        List<String> args = Arrays.asList(command.split(" "));
        if (args.isEmpty()) {
            throwIllegalCommandException();
        }

        switch (args.get(0).toUpperCase()) {
            case "GET" -> validateGetCommand(args);
            case "CREATE" -> validateCreateCommand(args);
            case "UPDATE" -> validateUpdateCommand(args);
            case "DELETE" -> validateDeleteCommand(args);
            default -> throwIllegalCommandException();
        }
    }

    private void validateGetCommand(List<String> args) {
        if (args.size() > 2) {
            throwIllegalCommandException();
        }

        if (!"GET".equalsIgnoreCase(args.get(0))) {
            throwIllegalCommandException();
        }

        if (args.size() > 1 && isNotInt(args.get(1))) {
            throwIllegalCommandException();
        }
    }

    private void validateCreateCommand(List<String> args) {
        if (args.size() < 2) {
            throwIllegalCommandException();
        }
        if (!"CREATE".equalsIgnoreCase(args.get(0))) {
            throwIllegalCommandException();
        }
    }

    private void validateUpdateCommand(List<String> args) {
        if (args.size() < 3) {
            throwIllegalCommandException();
        }
        if (!"UPDATE".equalsIgnoreCase(args.get(0))) {
            throwIllegalCommandException();
        }
        if (isNotInt(args.get(1))) {
            throwIllegalCommandException();
        }
    }

    private void validateDeleteCommand(List<String> args) {
        if (args.size() != 2) {
            throwIllegalCommandException();
        }

        if (!"DELETE".equalsIgnoreCase(args.get(0))) {
            throwIllegalCommandException();
        }

        if (isNotInt(args.get(1))) {
            throwIllegalCommandException();
        }
    }

    private boolean isNotInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private void throwIllegalCommandException() {
        throw new IllegalArgumentException("Invalid command entered");
    }
}