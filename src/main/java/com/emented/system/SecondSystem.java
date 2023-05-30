package com.emented.system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SecondSystem implements SystemTask {

    public static String system = """
            sin(x) + y - 1 = 0
            -2x^3 - 4y + 5 = 0
            """;

    private List<List<BiFunction<Double, Double, Double>>> systemDerivatives;

    public SecondSystem() {
        initSystem();
    }

    private void initSystem() {
        systemDerivatives = new ArrayList<>();

        List<BiFunction<Double, Double, Double>> firstLine = new ArrayList<>(), secondLine = new ArrayList<>();

        firstLine.add((x, y) -> Math.cos(x));
        firstLine.add((x, y) -> 1d);
        firstLine.add((x, y) -> -Math.sin(x) - y + 1);

        secondLine.add((x, y) -> -6 * x * 2);
        secondLine.add((x, y) -> -4d);
        secondLine.add((x, y) -> 2 * x * x * x + 4 * y - 5);

        systemDerivatives.add(firstLine);
        systemDerivatives.add(secondLine);
    }

    @Override
    public double firstEquation(double x) {
        return 1 - Math.sin(x);
    }

    @Override
    public double secondEquation(double x) {
        return (-2 * x * x * x + 5) / 4;
    }

    @Override
    public List<List<BiFunction<Double, Double, Double>>> getDerivatives() {
        return systemDerivatives;
    }
}
