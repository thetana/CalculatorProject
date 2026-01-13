package com.example.calculator;


import java.util.Objects;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface FucCal<T, U, R>  {
    R calculate(T t, U u, char o);

}
