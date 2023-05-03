package com.jahirmedina.lib;
import java.util.ArrayList;

public class TestCases {
    public static class TestCase {
        public String hidden;
        public String guess;
        public String expected;

        public TestCase(String h, String g, String e) {
            hidden = h;
            guess = g;
            expected = e;
        }
    }

    private final ArrayList<TestCase> testCases = new ArrayList<>();

    // Call the initializeTestCases() method in the constructor
    public TestCases() {
        initializeTestCases();
    }

    // Rename the main method to initializeTestCases and make it static
    private void initializeTestCases() {
        // add to an ArrayList of test cases
        this.testCases.add(new TestCase("1807", "7810", "1H3C")); // Test case 1
        this.testCases.add(new TestCase("1807", "2805", "2H0C")); // Test case 2
        this.testCases.add(new TestCase("1807", "9807", "3H0C")); // Test case 3
        this.testCases.add(new TestCase("1807", "1807", "4H0C")); // Test case 4
        this.testCases.add(new TestCase("1234", "5678", "0H0C")); // Test case 5
        this.testCases.add(new TestCase("1234", "4321", "0H4C")); // Test case 6
        this.testCases.add(new TestCase("1234", "1243", "2H2C")); // Test case 7
        this.testCases.add(new TestCase("4185", "5481", "1H3C")); // Test case 8
        this.testCases.add(new TestCase("4185", "4583", "2H1C")); // Test case 9
        this.testCases.add(new TestCase("4185", "5555", "1H0C")); // Test case 10
        this.testCases.add(new TestCase("4185", "5454", "0H2C")); // Test case 11
        // Could you insert additional pre-defined test cases here
    }

    public ArrayList<TestCase> getTestCases() {
        return testCases;
    }
}