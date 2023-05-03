package com.jahirmedina.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestRunner {

    private final HotAndCold hotAndCold = new HotAndCold();
    private final TestCases defaultTestCases = new TestCases();


    /**
     * Runs a series of test cases and prints the results to the console.
     */

    public void runTests() {
        // Get the list of test cases
        ArrayList<TestCases.TestCase> testCases = this.defaultTestCases.getTestCases();

        // Define counter variables
        int numTests = testCases.size();
        int numPassed = 0;

        // Run the pre-defined test cases
        for (int i = 0; i < testCases.size(); i++) {
            TestCases.TestCase t = testCases.get(i);
            if( this.hotAndCold.playGame(i+1,t.hidden, t.guess, t.expected) ){
                numPassed++;
            }
        }

        this.printTestResults(numTests, numPassed);
    }

    /**
     * Given a CSV file with test cases, runs each test case and prints the
     * results to the console.
     *
     * @param filename the name of the CSV file containing the test cases
     */
    public void runTestsFromFile(String filename) {
        String line = "";
        String csvSplitBy = ",";
        int numTests = 0, numPassed = 0;

        // Check current working directory
        String cwd = System.getProperty("user.dir");
        System.out.println("Executing Program from : " + cwd
                + "\nReading File from : " + filename + "\n");

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Read the contents of the CSV file, one line at a time
            while ((line = br.readLine()) != null) {
                // Split the line into the hidden number, guess, and expected hint
                String[] testCase = line.split(csvSplitBy);
                String hidden = testCase[0];
                String guess = testCase[1];
                String expectedHint = testCase[2];

                // Run the test case and compare the result with the expected hint
                numTests++;
                // We call assertHint() to print the results of the test case

                boolean passed = this.hotAndCold.playGame(numTests, hidden, guess, expectedHint);

                // Increment the number of tests passed if the current test passed
                if (passed) {
                    numPassed++;
                }
            }

            // Print the overall results of the test run to the console
            this.printTestResults(numTests, numPassed);
        } catch (IOException e) {
            System.out.println("Error reading file " + filename + ": " + e.getMessage());
        }
    }

    public void printTestResults(int numTests, int numPassed) {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                  TEST RESULTS                     ║");
        System.out.println("╟───────────────────────────────────────────────────╢");
        System.out.printf("║ Total Tests:  %-36d║\n", numTests);
        System.out.printf("║ Tests Passed: %-36d║\n", numPassed);
        System.out.printf("║ Tests Failed: %-36d║\n", numTests - numPassed);
        System.out.println("╚═══════════════════════════════════════════════════╝");
    }


    public void runDemo(){

        // run the test cases defined in the TestCases class
        System.out.println(
                "\n\n" +
                        "\t--------------------------------------------------\n" +
                        "\t----- Built-In TEST CASES (TestCases Class) ------\n" +
                        "\t--------------------------------------------------"   +
                        "\n\n");
        this.runTests();
        // Run the test cases from the CSV file if you need to
        System.out.println(
                "\n\n" +
                        "\t--------------------------------------------------\n" +
                        "\t--------- CSV TEST CASES (testCases.csv) ---------\n" +
                        "\t--------------------------------------------------"   +
                        "\n\n");
        this.runTestsFromFile("testCases.csv");
    }

}
