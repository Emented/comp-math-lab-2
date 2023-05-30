package com.emented.equation;

public interface Equation {
    double function(double x);

    double functionDerivative(double x);

    double secondFunctionDerivative(double x);

    String toString();
}
