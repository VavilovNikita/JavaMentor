package com.StringCrud.models;

public class Command {

    private final Person person;
    private final String command;
    private final Integer id;

    public Command(String command, int id, Person person) {
        this.command = command;
        this.id = id;
        this.person = person;
    }

    public Command(String command, int id) {
        this.command = command;
        this.id = id;
        this.person = null;
    }

    public Command(String command, Person person) {
        this.command = command;
        this.person = person;
        this.id = null;
    }

    public Command(String command) {
        this.command = command;
        this.person = null;
        this.id = null;
    }

    public Person getPerson() {
        return person;
    }

    public String getCommand() {
        return command;
    }

    public Integer getId() {
        return id;
    }

}
