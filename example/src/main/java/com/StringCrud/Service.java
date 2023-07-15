package com.StringCrud;

import com.StringCrud.models.Command;
import com.StringCrud.models.Person;

import java.util.Map;

public class Service {

    private final Storage storage;


    public Service(Storage storage) {
        this.storage = storage;
    }


    public void execute(Command command) {

        switch (command.getCommand()) {
            case "GET" -> get(command);
            case "GET_ALL" -> getAll();
            case "CREATE" -> create(command);
            case "UPDATE" -> update(command);
            case "DELETE" -> delete(command);
        }
    }

    public Map<Integer, Person> getMap() {
        return storage.getMap();
    }

    private void get(Command command) {
        Person person = storage.get(command.getId());
        System.out.println(person);
    }

    private void getAll() {
        getMap().forEach((key, value) -> System.out.println(String.format("%s: %s", key, value)));
    }

    private void create(Command command) {
        Integer id = storage.create(command.getPerson());
        System.out.printf("Person saved with id = {%s}", id);
        System.out.println();
    }
    private void update(Command command) {
        storage.update(command.getId(), command.getPerson());
        System.out.printf("Person with id = %s updated", command.getId());
        System.out.println();
    }

    private void delete(Command command) {
        storage.delete(command.getId());
        System.out.printf("Person with id = %s deleted", command.getId());
        System.out.println();
    }

}