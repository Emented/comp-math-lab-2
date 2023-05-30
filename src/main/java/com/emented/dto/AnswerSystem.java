package com.emented.dto;

import java.util.List;

import com.emented.system.SystemTask;

public class AnswerSystem {
    private final double x;
    private final double y;
    private final int i;
    private final List<Double> errors;
    private final SystemTask system;
    private final BigInterval interval;

    public AnswerSystem(double x,
                        double y,
                        int i,
                        List<Double> errors,
                        SystemTask system,
                        BigInterval interval) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.errors = errors;
        this.system = system;
        this.interval = interval;
    }

    public BigInterval getInterval() {
        return interval;
    }

    public SystemTask getSystem() {
        return system;
    }

    @Override
    public String toString() {
        return "Answer: " +
                "x=" + x + ", " +
                "y=" + y +
                ", was obtained in " + i +
                " iterations" +
                "\nerrors: " + errors;
    }
}
