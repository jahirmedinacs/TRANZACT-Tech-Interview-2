package com.jahirmedina;

import com.jahirmedina.lib.HotAndCold;
import com.jahirmedina.lib.TestRunner;

public class Main {

    private static final TestRunner testRunner = new TestRunner();
    private static final HotAndCold hotAndCold = new HotAndCold();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a valid argument. Use '--help' for more information.");
            return;
        }

        switch (args[0]) {
            case "--demo" -> testRunner.runDemo();
            case "--file" -> {
                if (args.length < 2) {
                    System.out.println("Please specify a file path.");
                    return;
                }
                String filePath = args[1];
                testRunner.runTestsFromFile(filePath);
            }
            case "--single" -> {
                if (args.length < 4) {
                    System.out.println("Please specify three arguments: two numbers and a string.");
                    return;
                }
                String num1 = args[1];
                String num2 = args[2];
                String str = args[3];
                hotAndCold.playGame(num1, num2, str);
            }
            case "--help" -> printHelp();
            default -> System.out.println("Invalid argument. Use '--help' for more information.");
        }
    }

    private static void printHelp() {
        System.out.println("Hot and Cold Game - Command-Line Interface");
        System.out.println();
        System.out.println("Usage from CLI: 'java -jar Hot-and-Cold.jar [options]'");
        System.out.println();
        System.out.println("Options:");
        System.out.println("--demo\t\t\t\tRun a demo of the Hot and Cold game.");
        System.out.println("--file <file-path>\t\t\tRead input from a file.");
        System.out.println("--single <number1> <number2> <string>\tRun a single test case.");
        System.out.println("--help\t\t\t\tPrint this help message.");
    }
}