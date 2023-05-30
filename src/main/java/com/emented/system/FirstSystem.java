package com.emented.system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FirstSystem implements SystemTask {
    public static String system = """
            x^2 / 8 + y = 0
            y - x^3 / 16 - 1 = 0
            """;

    private List<List<BiFunction<Double, Double, Double>>> functions;

    public FirstSystem() {
        initSystem();
    }

    private void initSystem() {
        functions = new ArrayList<>();

        List<BiFunction<Double, Double, Double>> firstLine = new ArrayList<>(), secondLine = new ArrayList<>();

        firstLine.add((x, y) -> x / 4);
        firstLine.add((x, y) -> 1d);
        firstLine.add((x, y) -> - x * x / 8 - y);

        secondLine.add((x, y) -> -3 * x * x / 16);
        secondLine.add((x, y) -> 1d);
        secondLine.add((x, y) -> 1 - y + x * x * x / 16);

        functions.add(firstLine);
        functions.add(secondLine);
    }

    @Override
    public double firstEquation(double x) {
        return -x * x / 8;
    }

    @Override
    public double secondEquation(double x) {
        return x * x * x / 16 + 1;
    }

    public List<List<BiFunction<Double, Double, Double>>> getDerivatives() {
        return functions;
    }
}
