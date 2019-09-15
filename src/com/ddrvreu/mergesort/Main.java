package com.ddrvreu.mergesort;

import com.ddrvreu.mergesort.parser.ArgsKeeper;
import com.ddrvreu.mergesort.parser.Parser;
import com.ddrvreu.mergesort.sorter.MergeSorter;
import com.ddrvreu.mergesort.sorter.MergeSorterFactory;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser(args);
        ArgsKeeper argsKeeper = parser.fill();

        if(!checkArgsKeeper(argsKeeper)){
            return;
        }

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(new File(argsKeeper.getOutputFile()));
        }
        catch (FileNotFoundException ex) {
            System.out.println(Messages.NO_OUTPUT_FILE);
            return;
        }

        List<FileInputStream> inputStreams = argsKeeper.getInputFiles().stream()
                .map(inputFile -> {
                    try {
                        return new FileInputStream(new File(inputFile));
                    }
                    catch (FileNotFoundException ex) {
                        System.out.println(Messages.NO_INPUT_FILE + inputFile);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (inputStreams.isEmpty()) {
            System.out.println(Messages.NO_INPUT_FILES);
            return;
        }

        Comparator comparator = null;
        switch (argsKeeper.getSortOrder()) {
            case ASC:  comparator = Comparator.naturalOrder();
                       break;

            case DESC: comparator = Comparator.reverseOrder();
                       break;
        }

        MergeSorter sorter = null;
        switch (argsKeeper.getSortType()) {
            case INTEGER: sorter = MergeSorterFactory.createIntegerSorter(comparator);
                          break;

            case STRING:  sorter = MergeSorterFactory.createStringSorter(comparator);
                          break;
        }

        try {
            sorter.sort(outputStream, inputStreams);
        }
        finally {
            outputStream.close();

            for (InputStream stream : inputStreams) {
                stream.close();
            }
        }

    }

    private static boolean checkArgsKeeper(ArgsKeeper argsKeeper) {
        if(argsKeeper.getInputFiles().isEmpty()) {
            System.out.println(Messages.NO_INPUT_FILES);
            return false;
        }

        if(argsKeeper.getOutputFile() == null) {
            System.out.println(Messages.NO_OUTPUT_FILE);
            return false;
        }

        if(argsKeeper.getSortOrder() == null) {
            System.out.println(Messages.NO_SORT_ORDER);
            return false;
        }

        if(argsKeeper.getSortType() == null) {
            System.out.println(Messages.NO_SORT_TYPE);
            return false;
        }

        return true;
    }
}
