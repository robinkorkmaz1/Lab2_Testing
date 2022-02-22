package com.example;

public class StringCalculator {
    public int Add(String numbers)  {
        int rst = 0;

        if (numbers == "")
            return rst;

        String[] numStrings = numbers.split(",");

        for (String num : numStrings) {
            rst += Integer.parseInt(num);
        }

        return rst;
    }
}