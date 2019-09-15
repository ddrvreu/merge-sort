package com.ddrvreu.mergesort.sorter;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class MergeSorter<T extends Comparable<T>> {

    private final Comparator<T> comparator;

    public MergeSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    protected abstract T readValue(Scanner scanner);

    public void sort(OutputStream output, List<InputStream> inputs) {

        List<Scanner> inScanners = inputs.stream()
                .map(Scanner::new)
                .collect(Collectors.toList());

        PrintWriter outWriter = new PrintWriter(output, true);

        sort(outWriter, inScanners);
    }

    private void sort(PrintWriter output, List<Scanner> inputs){

        List<InputValue<T>> inputValues = inputs.stream()
                .map(InputValue<T>::new)
                .peek(this::nextValue)
                .filter(inputValue -> inputValue.currentValue != null)
                .collect(Collectors.toList());

        while (!inputValues.isEmpty()){

            InputValue<T> outValue = inputValues.stream()
                    .min((o1, o2) -> comparator.compare(o1.currentValue, o2.currentValue))
                    .get();

            output.println(outValue.currentValue);
            nextValue(outValue);

            if(outValue.currentValue == null){
                inputValues.remove(outValue);
            }
        }
    }

    private void nextValue(InputValue<T> input){
        T next = readValue(input.scanner);

        while(next != null
                && (input.currentValue != null && comparator.compare(next, input.currentValue) < 0)) {
            next = readValue(input.scanner);
        }

        input.currentValue = next;
    }

    private static class InputValue<T> {

        final Scanner scanner;

        T currentValue;

        InputValue(Scanner scanner) {
            this.scanner = scanner;
        }
    }

}
