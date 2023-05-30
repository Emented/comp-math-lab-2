package com.emented.math;

import com.emented.dto.AnswerEquation;
import com.emented.dto.InputData;
import com.emented.equation.Equation;

public class SimpleIterationMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {

        double a = interval.getA();
        double b = interval.getB();
        double epsilon = interval.getEpsilon();

        double aDerivative = Math.abs(equation.functionDerivative(a));
        double bDerivative = Math.abs(equation.functionDerivative(b));

        double lambda = -1 / Math.max(aDerivative, bDerivative);

        double aPhiDerivative = Math.abs(phiDerivative(a, equation, lambda));
        double bPhiDerivative = Math.abs(phiDerivative(b, equation, lambda));

        if (aPhiDerivative >= 1 || bPhiDerivative >= 1) {
            throw new IllegalArgumentException("Sufficient convergence condition is not met");
        }

        double x0 = b;
        double x1 = phi(x0, equation, lambda);

        int iteration = 0;
        do {
            iteration++;

            double m = Math.abs(x1 - x0);

            if (m <= epsilon) {
                break;
            }

            double x2 = phi(x1, equation, lambda);

            x0 = x1;
            x1 = x2;
        } while (true);

        return new AnswerEquation(x1, equation.function(x1), iteration, equation, interval);
    }

    private double phi(double x, Equation equation, double lambda) {

        return x + lambda * equation.function(x);
    }

    private double phiDerivative(double x, Equation equation, double lambda) {
        return 1 + lambda * equation.functionDerivative(x);
    }
}
