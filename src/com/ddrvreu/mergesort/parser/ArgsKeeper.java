package com.ddrvreu.mergesort.parser;

import java.util.ArrayList;
import java.util.List;

public class ArgsKeeper {

    private Type sortType;

    private Order sortOrder = Order.ASC;

    public enum Type {
        INTEGER,
        STRING
    }

    public enum Order {
        ASC,
        DESC
    }

    private final List<String> inputFiles = new ArrayList<>();

    private String outputFile;

    public void addInputFile(String name){
        inputFiles.add(name);
    }

    public void setSortType(Type sortType) {
        this.sortType = sortType;
    }

    public void setSortOrder(Order sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public Type getSortType() {
        return sortType;
    }

    public Order getSortOrder() {
        return sortOrder;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String toString(){
        return getSortType() + "\n" +
                getSortOrder() + "\n" +
                getOutputFile() + "\n" +
                getInputFiles();
    }
}
