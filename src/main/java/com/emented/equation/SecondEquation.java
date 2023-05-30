package com.emented.equation;


public class SecondEquation implements Equation {
    public static String equation = "2cos(2x) + 3sin(x)";


    @Override
    public double function(double x) {
        return 2 * Math.cos(2 * x) + 3 * Math.sin(x);
    }

    @Override
    public double functionDerivative(double x) {
        return -4 * Math.sin(2 * x) + 3 * Math.cos(x);
    }

    @Override
    public double secondFunctionDerivative(double x) {
        return -8 * Math.cos(2 * x) - 3 * Math.sin(x);
    }

    @Override
    public String toString() {
        return equation;
    }
}
