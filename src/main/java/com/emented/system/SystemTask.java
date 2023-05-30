package com.emented.system;

import java.util.List;
import java.util.function.BiFunction;

public interface SystemTask {
    double firstEquation(double x);

    double secondEquation(double x);

    List<List<BiFunction<Double, Double, Double>>> getDerivatives();

}
