package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test
    public void Step1Test() {
        assertEquals(0, sc.Add(""));
        assertEquals(1, sc.Add("1"));
        assertEquals(5, sc.Add("2,3"));
    }

    @Test
    public void Step2Test() {
        assertEquals(15, sc.Add("4,5,6"));
    }
}