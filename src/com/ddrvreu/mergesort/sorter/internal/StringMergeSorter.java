package com.ddrvreu.mergesort.sorter.internal;

import com.ddrvreu.mergesort.sorter.MergeSorter;

import java.util.Comparator;
import java.util.Scanner;

public class StringMergeSorter extends MergeSorter<String> {

    public StringMergeSorter(Comparator<String> comparator) {
        super(comparator);
    }

    @Override
    protected String readValue(Scanner scanner) {
        String value = null;

        while (scanner.hasNextLine() && (value == null || value.isEmpty())) {
           value = scanner.nextLine();
        }

        return value;
    }
}
