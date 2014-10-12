package com.sara.interviews.bits;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitsTest {
    
    @Test
    public void testReplaceWithAverageCase() {
        int n = Integer.parseInt("1000101010000111",2);
        int m = Integer.parseInt("11011",2);
        int expected = Integer.parseInt("1000101110110111",2);
        int actual = Bits.replaceWith(n,m,8,4);
        System.out.println("n: "+Integer.toBinaryString(n));
        System.out.println("m: "+Integer.toBinaryString(m));
        System.out.println("expected: "+Integer.toBinaryString(expected));
        System.out.println("actual: "+Integer.toBinaryString(actual));
        assertEquals(expected,actual);
    }

    @Test
    public void testReplaceAllZeroesWithSomeOnes() {
        int n = Integer.parseInt("000000000000000",2);
        int m = Integer.parseInt("111",2);
        int expected = Integer.parseInt("000000111000000",2);
        int actual = Bits.replaceWith(n,m,8,6);
        System.out.println("n: "+Integer.toBinaryString(n));
        System.out.println("m: "+Integer.toBinaryString(m));
        System.out.println("expected: "+Integer.toBinaryString(expected));
        System.out.println("actual: "+Integer.toBinaryString(actual));
        assertEquals(expected,actual);
    }

    @Test
    public void testReplaceTheSame() {
        int n = Integer.parseInt("0111010101100111",2);
        int m = Integer.parseInt("0111010101100111",2);
        int expected = Integer.parseInt("000000111000000",2);
        int actual = Bits.replaceWith(n,m,8,6);
        System.out.println("n: "+Integer.toBinaryString(n));
        System.out.println("m: "+Integer.toBinaryString(m));
        System.out.println("expected: "+Integer.toBinaryString(expected));
        System.out.println("actual: "+Integer.toBinaryString(actual));
        assertEquals(expected,actual);
    }



}