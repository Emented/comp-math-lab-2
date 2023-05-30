package com.emented.math;

import java.util.ArrayList;
import java.util.List;

import com.emented.dto.BigInterval;
import com.emented.dto.InputData;
import com.emented.equation.Equation;

public class IntervalCalculator {
    public List<InputData> calculateIntervals(Equation equation, BigInterval bigInterval) {

        List<InputData> answer = new ArrayList<>();

        for (double i = bigInterval.a() + 0.5; i < bigInterval.b(); i += 0.5) {
            double left = equation.function(i - 0.5);
            double right = equation.function(i);
            if (left * right <= 0) {
                answer.add(new InputData(i - 0.5, i));
            }
        }

        return answer;
    }
}
