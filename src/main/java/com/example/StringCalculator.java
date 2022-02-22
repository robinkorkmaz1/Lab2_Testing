package com.example;

public class StringCalculator {
    public int Add(String numbers) throws Exception {
        int rst = 0;

        if (numbers == "")
            return rst;

        if (numbers.startsWith("//"))
            numbers = numbers.substring(3).replaceAll(numbers.substring(2, 3), ",");

        String[] numStrings = numbers.split(",|\n");

        String errorMsg = "negatives not allowed: ";

        for (String num : numStrings) {
            int numVal = Integer.parseInt(num);
            if (numVal < 0)
                errorMsg += num + " ";
            rst += numVal;
        }

        if (errorMsg.length() > 23)
            throw new Exception(errorMsg);
        return rst;
    }
}