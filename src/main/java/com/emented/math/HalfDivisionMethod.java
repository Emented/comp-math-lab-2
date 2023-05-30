package com.emented.math;

import com.emented.dto.AnswerEquation;
import com.emented.dto.InputData;
import com.emented.equation.Equation;

public class HalfDivisionMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {
        double a = interval.getA();
        double b = interval.getB();
        double epsilon = interval.getEpsilon();

        double x;

        int iteration = 0;
        do {
            iteration++;
            x = (a + b) / 2;

            if (equation.function(a) * equation.function(x) > 0) {
                a = x;
            } else {
                b = x;
            }
        } while (!(Math.abs(a - b) <= epsilon) || !(Math.abs(equation.function(x)) < epsilon));

        return new AnswerEquation(x, equation.function(x), iteration, equation, interval);

    }
}
