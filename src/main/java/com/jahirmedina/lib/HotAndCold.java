package com.jahirmedina.lib;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class HotAndCold {

    public static void main(String[] args) {
        new HotAndCold();
    }

    /**
     * Given the hidden number and the guess, returns a hint string indicating
     * the number of Hots and Colds. A Hot is when the digit in the guess is
     * correct and is in the correct position. A Cold is when the digit in the
     * guess is correct but is in the wrong position.
     *
     * @param hiddenStr the hidden number
     * @param guessStr the guess
     * @return a hint string indicating the number of Hots and Colds
     */
    public String getHint(String hiddenStr, String guessStr) {
        // Display the hidden and guess numbers for reference, for "production" purposes
        // comment out the following two lines
        System.out.println("Hidden Number : " + hiddenStr);
        System.out.println("Guess Number : " + guessStr);
        // Convert the hidden and guess strings to integer arrays
        int n = hiddenStr.length();
        int[] hiddenArr = hiddenStr.chars().map(Character::getNumericValue).toArray();
        int[] guessArr = guessStr.chars().map(Character::getNumericValue).toArray();

        // Initialize counts for Hots, Colds, and occurrences of hidden digits
        int hots = 0;
        Map<Integer, Long> counts =
                Arrays.stream(hiddenArr)
                        .boxed()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.counting()
                                )
                        );

        // Count the number of Hots and decrement the counts for matching digits in hidden and guess arrays
        for (int i = 0; i < n; i++) {
            if (guessArr[i] == hiddenArr[i]) {
                hots++;
                counts.put(hiddenArr[i], counts.get(hiddenArr[i]) - 1L);
                guessArr[i] = -1;
                hiddenArr[i] = -1;
            }
        }

        // Count the number of Colds by looking up the counts of remaining digits in the hidden array
        int colds = (int) Arrays.stream(guessArr).filter(digit -> digit != -1)
                .boxed()
                .filter(digit -> counts.containsKey(digit) && counts.get(digit) > 0)
                .peek(digit -> counts.put(digit, counts.get(digit) - 1L))
                .count();

        // Return the hint as a string in the format "xHxC"
        return hots + "H" + colds + "C";
    }

    /**
     * Given a test case number, the actual result, and the expected result,
     * prints the results of the test to the console and returns a boolean
     * indicating whether the test passed or failed.
     *
     * @param actualResult the actual result of the test
     * @param expectedResult the expected result of the test
     * @return true if the test passed, false otherwise
     */
    public boolean assertHint(String actualResult, String expectedResult) {
        boolean passed = actualResult.equals(expectedResult);
        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        System.out.println(passed ? "PASSED" : "FAILED");
        System.out.println();
        return passed;
    }

    /**
     * Class Method to run a Hot and Cold game once
     * it returns the same boolean as assertHint
     * indicating whether the test or play passed or failed.
     *
     * @param caseNumber the number of the test case
     * @param hiddenStr the hidden number
     * @param guessStr the guess
     * @param expectedResult the expected result of the test
     * @return true if the test passed, false otherwise
     */
    public boolean playGame(int caseNumber, String hiddenStr, String guessStr, String expectedResult) {

        System.out.println("Test Case " + caseNumber + ":");

        String result = getHint(hiddenStr, guessStr);
        return assertHint(result, expectedResult);
    }

    public void playGame(String hiddenStr, String guessStr, String expectedResult) {

        System.out.println("Playing Game: ");

        String result = getHint(hiddenStr, guessStr);
        assertHint(result, expectedResult);
    }

}