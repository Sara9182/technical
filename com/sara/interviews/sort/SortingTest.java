package com.sara.interviews.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    private <T extends Comparable<T>> boolean isSorted(T[] array) {
        boolean sorted = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i+1]) > 0) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }


    @Test
    public void testIntegerRadixSortEmptyArray() {
        Integer[] array = new Integer[0];
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testIntegerRadixSortSingleDigitNumbers() {
        Integer[] array = {3,5,1,4,2};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testIntegerRadixSortMultipleDigitNumbers() {
        Integer[] array = {311,354,221,224,289,301,100,564};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testIntegerRadixSortVariableDigitNumbers() {
        Integer[] array = {3211,35,222221,24,8966,4,100,564};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testStringRadixSortEmptyArray() {
        String[] array = new String[0];
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testStringRadixSortSingleDigitStrings() {
        String[] array = {"c","b","d","a","f"};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testStringRadixSortMultipleDigitStrings() {
        String[] array = {"asc","rwb","ssd","aaa","rwf"};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }


    @Test
    public void testStringRadixSortVariableDigitStrings() {
        String[] array = {"ascasd","r","assd","a","rwf","bdqas", "rwfr"};
        Sorting.radixSort(array);
        assertTrue(isSorted(array));
    }

}