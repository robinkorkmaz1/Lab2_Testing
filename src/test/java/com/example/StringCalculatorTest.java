package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    public void Step1Test() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.Add(""));
        assertEquals(1, sc.Add("1"));
        assertEquals(5, sc.Add("2,3"));
    }
}