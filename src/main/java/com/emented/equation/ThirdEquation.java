package com.emented.equation;

public class ThirdEquation implements Equation {
    public static String equation = "x^2 - 8*x + 9";

    @Override
    public double function(double x) {
        return x * x - 8 * x + 9;
    }

    @Override
    public double functionDerivative(double x) {
        return 2 * x - 8;
    }

    @Override
    public double secondFunctionDerivative(double x) {
        return 2;
    }

    @Override
    public String toString() {
        return equation;
    }
}
