package com.example;

public class StringCalculator {
    public int Add(String numbers)  {
        if (numbers == "")
            return 0;

        String[] numStrings = numbers.split(",");

        if (numStrings.length == 1)
            return Integer.parseInt(numStrings[0]);
        else
            return Integer.parseInt(numStrings[0]) + Integer.parseInt(numStrings[1]);
    }
}