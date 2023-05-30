package com.emented.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.emented.dto.AnswerSystem;
import com.emented.dto.BigInterval;
import com.emented.system.SystemTask;

public class NewtonSystemMethod implements SystemSolutionMethod {

    @Override
    public AnswerSystem solveSystem(BigInterval interval, SystemTask system) {

        GaussSystemSolver gauss = new GaussSystemSolver();

        double x0 = interval.a();
        double y0 = interval.b();

        float e = 0.01f;

        List<List<BiFunction<Double, Double, Double>>> systemDerivatives = system.getDerivatives();

        double[][] matrix = new double[2][3];
        List<Double> errors = new ArrayList<>();

        int iteration = 0;
        do {
            iteration++;
            for (int i = 0; i < systemDerivatives.size(); i++) {
                for (int j = 0; j < systemDerivatives.get(i).size(); j++) {
                    matrix[i][j] = systemDerivatives.get(i).get(j).apply(x0, y0);
                }
            }

            double[] answer = gauss.solve(matrix);

            double x1 = answer[0] + x0;
            double y1 = answer[1] + y0;

            errors.add(Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0)));

            if (Math.abs(x1 - x0) <= e && Math.abs(y1 - y0) <= e) {
                return new AnswerSystem(x1, y1, iteration, errors, system, interval);
            }

            x0 = x1;
            y0 = y1;

        } while (iteration < 500);

        throw new IllegalArgumentException("System didn't solve in 500 iterations, check your start approximations and" +
                " try again");
    }

}
