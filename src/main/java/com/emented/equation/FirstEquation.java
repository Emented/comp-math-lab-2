package com.emented.equation;

public class FirstEquation implements Equation {
    public static String equation = "x^3 - x + 4";

    @Override
    public double function(double x) {
        return x * x * x - x + 4;
    }

    @Override
    public double functionDerivative(double x) {
        return 3 * x * x - 1;
    }

    @Override
    public double secondFunctionDerivative(double x) {
        return 6 * x;
    }

    @Override
    public String toString() {
        return equation;
    }
}
