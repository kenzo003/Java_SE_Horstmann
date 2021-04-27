package com.horstmann.ch3;

import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        print(IntSequence.constant(1), 7);
        print(IntSequence.constantLambda(7), 4);
    }

    private static void print(IntSequence sequence, int limit) {
        Stream.generate(sequence::next).limit(limit).forEach(System.out::print);
        System.out.println();
    }
}

