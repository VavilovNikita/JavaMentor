package com.StringCrud;

public class Printer {
    private static final Printer PRINTER = new Printer();

    private Printer(){}

    public static Printer getPrinter(){
        return PRINTER;
    }
    public void help(){
        System.out.println(
                "Command list\n" +
                "CREATE name age\n" +
                "GET\n" +
                "GET id\n" +
                "UPDATE id name age\n" +
                "DELETE id\n" +
                "HELP");
    }
    public void enter(){
        System.out.println("Enter: ");
    }
    public void printMessage(String s){
        System.out.println(s);
    }
}
