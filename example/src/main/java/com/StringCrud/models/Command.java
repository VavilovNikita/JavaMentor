package com.StringCrud.models;

public class Command {

    private final Person person;
    private final CommandType commandType;
    private final Integer id;

    public Command(CommandType command, int id, Person person) {
        this.commandType = command;
        this.id = id;
        this.person = person;
    }

    public Command(CommandType command, int id) {
        this.commandType = command;
        this.id = id;
        this.person = null;
    }

    public Command(CommandType command, Person person) {
        this.commandType = command;
        this.person = person;
        this.id = null;
    }

    public Command(CommandType command) {
        this.commandType = command;
        this.person = null;
        this.id = null;
    }

    public Person getPerson() {
        return person;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Integer getId() {
        return id;
    }

}
