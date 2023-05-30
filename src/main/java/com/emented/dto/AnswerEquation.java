package com.emented.dto;

import com.emented.equation.Equation;

public class AnswerEquation {
    private final double x;
    private final double fx;
    private final int i;
    private final Equation equation;
    private final InputData interval;

    public AnswerEquation(double x, double fx, int i, Equation equation, InputData interval) {
        this.x = x;
        this.fx = fx;
        this.i = i;
        this.equation = equation;
        this.interval = interval;
    }

    public double getX() {
        return x;
    }

    public Equation getEquation() {
        return equation;
    }

    public InputData getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "Answer: " +
                "x=" + x +
                ", f(x)=" + fx +
                ", was obtained in " + i +
                " iterations";
    }
}
