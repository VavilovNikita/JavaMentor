package com.StringCrud;

import com.StringCrud.models.Command;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Loader loader = new Loader();

        Validator validator = new Validator();
        Parser parser = new Parser(validator);

        Storage storage = new Storage(loader.loadFromFile());
        Service service = new Service(storage);

        try (Scanner scanner = new Scanner(System.in)) {
            Printer.getPrinter().help();
            while (true) {
                try {
                    Printer.getPrinter().enter();
                    String line = scanner.nextLine();
                    if ("QUIT".equalsIgnoreCase(line)) {
                        loader.saveToFile(service.getMap());
                        break;
                    }
                    if ("HELP".equals(line) || "help".equals(line)) {
                        Printer.getPrinter().help();
                        continue;
                    }
                    Command command = parser.parse(line);
                    service.execute(command);

                } catch (Exception e) {
                    Printer.getPrinter().printMessage(e.getMessage());
                }

            }
        }
    }
}