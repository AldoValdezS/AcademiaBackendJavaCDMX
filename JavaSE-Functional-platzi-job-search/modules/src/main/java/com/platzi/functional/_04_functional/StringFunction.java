package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class StringFunction {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\""+text+"\"";
        UnaryOperator<String> addMark = text -> text+"!";
        System.out.println( quote.apply("Hola mundo") );
        System.out.println( addMark.apply("Hola mundo") );

        //BiFunction<Integer,Integer,Integer> multiplicacion=
                //(x,y)->x*y;
        BiFunction<String,Integer,String> leftPad=
                (text, number) -> String.format("%"+number+"s", text);
        System.out.println(leftPad.apply("Java",10));


    }
}
