package com.emented.dto;

public class InputData {
    private final double a;
    private final double b;
    private double epsilon;

    public InputData(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public InputData(double a, double b, double epsilon) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public String toString() {
        return "isolation interval: [" +
                a +
                ", " + b +
                ']';
    }
}
