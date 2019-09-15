package com.ddrvreu.mergesort.sorter;

import com.ddrvreu.mergesort.sorter.internal.IntegerMergeSorter;
import com.ddrvreu.mergesort.sorter.internal.StringMergeSorter;

import java.util.Comparator;

public class MergeSorterFactory {

    public static MergeSorter<String> createStringSorter(Comparator comparator) {
        return new StringMergeSorter(comparator);
    }

    public  static MergeSorter<Integer> createIntegerSorter(Comparator comparator) {
        return new IntegerMergeSorter(comparator);
    }
}
