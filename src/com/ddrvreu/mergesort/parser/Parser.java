package com.ddrvreu.mergesort.parser;

public class Parser {

    String[] args;

    public Parser(String[] args) {
        this.args = args;
    }

    public ArgsKeeper fill (){

        ArgsKeeper argsKeeper = new ArgsKeeper();

        for(String arg : args){

            if(arg.equals(ArgConstants.TYPE_INTEGER)){
                argsKeeper.setSortType(ArgsKeeper.Type.INTEGER);
                continue;
            }

            if(arg.equals(ArgConstants.TYPE_STRING)){
                argsKeeper.setSortType(ArgsKeeper.Type.STRING);
                continue;
            }

            if(arg.equals(ArgConstants.ORDER_ASC)){
                argsKeeper.setSortOrder(ArgsKeeper.Order.ASC);
                continue;
            }

            if(arg.equals(ArgConstants.ORDER_DESC)){
                argsKeeper.setSortOrder(ArgsKeeper.Order.DESC);
                continue;
            }

            if(argsKeeper.getOutputFile() == null){
                argsKeeper.setOutputFile(arg);
                continue;
            }
            argsKeeper.addInputFile(arg);
        }
        return argsKeeper;
    }
}
