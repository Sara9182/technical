package com.sara.interviews.sort;

import com.google.common.collect.Lists;
import java.util.*;
import static java.lang.Math.*;

public class Sorting {

    private static int length(Integer item) {
        return (int) log10(item) + 1;
    }

    private static int length(String item) {
        return (item).length();
    }

    /**
     * Returns the symbol at pos position from the end or minimum value if pos is greater or equal the length of the item
     */
    public static int symbolFromEnd(Integer item, int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException();
        }
        if (pos >= length(item)) {
            return Integer.MIN_VALUE;
        }
        for (int i=0; i<pos; i++){
            item /= 10;
        }
        return item % 10;
    }

    /**
     * Returns the symbol at pos position from the start or minimum value if pos is greater or equal the length of the item
     */
    public static char symbolFromStart(String item, int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException();
        }
        return pos < item.length() ? item.charAt(pos) : Character.MIN_VALUE;
    }

    private static int findMaxLength(Integer[] array) {
        int max = 0;
        for (Integer number : array) {
            if (length(number) > max) {
                max = length(number);
            }
        }
        return max;
    }

    private static int findMaxLength(List<String> list) {
        int max = 0;
        for (String item : list) {
            if (length(item) > max) {
                max = length(item);
            }
        }
        return max;
    }

    private static <K,T> List<T> mergeListsInMap(SortedMap<K,List<T>> map) {
        Set<K> keys = map.keySet();
        List<T> list = Lists.newArrayList();
        keys.forEach(key -> list.addAll(map.get(key)));
        return list;
    }

    private static void intBucketPositionSort(List<Integer> arrayList, int pos) {
        SortedMap<Integer,List<Integer>> buckets = new TreeMap<>();
        for (int item : arrayList) {
            int symbol = symbolFromEnd(item, pos);
            List<Integer> list = buckets.get(symbol);
            if (list == null) {
                list = Lists.newArrayList();
                buckets.put(symbol,list);
            }
            list.add(item);
        }
        arrayList.clear();
        arrayList.addAll(mergeListsInMap(buckets));
    }

    private static void strBucketPositionSort(List<String> arrayList, int pos) {
        if (pos >= findMaxLength(arrayList)) {
            return;
        }
        SortedMap<Character,List<String>> buckets = new TreeMap<>();
        for (String item : arrayList) {
            char symbol = symbolFromStart(item, pos);
            List<String> list = buckets.get(symbol);
            if (list == null) {
                list = Lists.newArrayList();
                buckets.put(symbol,list);
            }
            list.add(item);
        }
        for (char c : buckets.keySet()) {
            strBucketPositionSort(buckets.get(c), pos+1);
        }
        arrayList.clear();
        arrayList.addAll(mergeListsInMap(buckets));
    }

    private static <T> void copyListToArray(List<T> arrayList, T[] array) {
        int i = 0;
        for (T item : arrayList) {
            array[i++] = item;
        }
    }

    public static void radixSort(Integer[] array) {
        int maxLength = findMaxLength(array);
        List<Integer> arrayList = Lists.newArrayList(array);
        //least significant digit bucket sort
        for (int i=0; i<maxLength; i++) {
            intBucketPositionSort(arrayList, i);
        }
        copyListToArray(arrayList,array);
    }

    public static void radixSort(String[] array) {
        List<String> arrayList = Lists.newArrayList(array);
        //most significant digit recursive bucket sort
        strBucketPositionSort(arrayList,0);
        copyListToArray(arrayList,array);
    }

}
