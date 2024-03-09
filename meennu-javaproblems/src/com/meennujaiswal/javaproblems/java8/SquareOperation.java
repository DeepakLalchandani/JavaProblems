package com.meennujaiswal.javaproblems.java8;

import java.util.function.Consumer;

public class SquareOperation implements Consumer<Integer> {
    @Override
    public void accept(Integer number) {
        number = number * number;
    }
}
