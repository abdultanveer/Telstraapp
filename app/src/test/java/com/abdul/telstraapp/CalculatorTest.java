package com.abdul.telstraapp;

import junit.framework.TestCase;

import org.junit.Test;

public class CalculatorTest extends TestCase {

    @Test
    public void test_add(){
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

    @Test
    public void test_mul(){
        int expected = 20;
        int actual = Calculator.mul(5,4);
        assertEquals(expected,actual);
    }
}