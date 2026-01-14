package com.example.calculator;


@FunctionalInterface
public interface Calculateable<T, U, R>  {
    R calculate(T t, U u, char o);

}
