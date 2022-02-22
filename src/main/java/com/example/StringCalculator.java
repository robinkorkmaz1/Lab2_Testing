package com.example;

public class StringCalculator {
    public int Add(String numbers)  {
        int rst = 0;

        if (numbers == "")
            return rst;

        if (numbers.startsWith("//")) 
            numbers = numbers.substring(3).replaceAll(numbers.substring(2,3), ",");

        String[] numStrings = numbers.split(",|\n");

        for (String num : numStrings) {
            rst += Integer.parseInt(num);
        }

        return rst;
    }
}