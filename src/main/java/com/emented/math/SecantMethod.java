package com.emented.math;

import com.emented.dto.AnswerEquation;
import com.emented.dto.InputData;
import com.emented.equation.Equation;

public class SecantMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {

        double x0, x1;

        if (equation.function(interval.getA()) * equation.secondFunctionDerivative(interval.getA()) > 0) {
            x0 = interval.getA();
            x1 = x0 + 0.03;
        } else {
            x0 = interval.getB();
            x1 = x0 - 0.03;
        }

        double epsilon = interval.getEpsilon();
        double x2;

        int iteration = 0;
        do {
            iteration++;
            x2 = x1 - ((x1 - x0) / (equation.function(x1) - equation.function(x0)) * equation.function(x1));

            double m = Math.abs(x2 - x1);
            System.out.println(x0 + " " + x1 + " " + x2);
            if (m <= epsilon) {
                break;
            }
            x0 = x1;
            x1 = x2;

        } while (true);

        return new AnswerEquation(x2, equation.function(x2), iteration, equation, interval);
    }
}
