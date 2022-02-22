package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test
    public void Step1Test() throws Exception {
        assertEquals(0, sc.Add(""));
        assertEquals(1, sc.Add("1"));
        assertEquals(5, sc.Add("2,3"));
    }

    @Test
    public void Step2Test() throws Exception {
        assertEquals(15, sc.Add("4,5,6"));
    }

    @Test
    public void Step3Test() throws Exception {
        assertEquals(6, sc.Add("1\n2,3"));
    }

    @Test
    public void Step4Test() throws Exception {
        assertEquals(6, sc.Add("//;1;2;3"));
    }

    @Test
    public void Step5Test() {
        Exception ex = assertThrows(Exception.class, ()-> sc.Add("-1,-2,3"));
        assertTrue(ex.getMessage().contains("-1") && ex.getMessage().contains("-2"));
    }

    @Test
    public void Step6Test() throws Exception {
        assertEquals(2, sc.Add("2,10001"));
    }

    @Test
    public void Step7Test() throws Exception {
        assertEquals(6, sc.Add("//,;\n1,;2,;3"));
    }
}