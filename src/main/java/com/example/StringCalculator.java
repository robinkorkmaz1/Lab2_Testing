package com.example;

public class StringCalculator {
    public int Add(String numbers) throws Exception {
        int rst = 0;

        if (numbers == "")
            return rst;

        if (numbers.startsWith("//")) {
            if (numbers.contains("\n")) {
                String delimiterStr = numbers.substring(2, numbers.indexOf("\n"));
                if (delimiterStr.startsWith("[") && delimiterStr.endsWith("]")){
                    String[] delimiters = delimiterStr.substring(1,delimiterStr.length()-1).split("\\]\\[");
                    numbers = numbers.substring(numbers.indexOf("\n") + 1);
                    for (String delimiter : delimiters)
                        numbers = numbers.replaceAll(delimiter, ",");
                }
                else
                numbers = numbers.substring(numbers.indexOf("\n") + 1).replaceAll(delimiterStr, ",");
            }
            else
                numbers = numbers.substring(3).replaceAll(numbers.substring(2, 3), ",");
        }

        String[] numStrings = numbers.split(",|\n");

        String errorMsg = "negatives not allowed: ";

        for (String num : numStrings) {
            int numVal = Integer.parseInt(num);
            if (numVal < 0)
                errorMsg += num + " ";
            else if (numVal <= 1000)
                rst += numVal;
        }

        if (errorMsg.length() > 23)
            throw new Exception(errorMsg);
        return rst;
    }
}