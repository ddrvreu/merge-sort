package com.ddrvreu.mergesort.sorter.internal;

import com.ddrvreu.mergesort.sorter.MergeSorter;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerMergeSorter extends MergeSorter<Integer> {

    public IntegerMergeSorter(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    protected Integer readValue(Scanner scanner) {
        Integer value = null;

         while (value == null && scanner.hasNextInt()) {
             try {
                 value = scanner.nextInt();
             }
             catch (InputMismatchException ex) {
                 //get next
             }
         }

         return value;
    }
}
