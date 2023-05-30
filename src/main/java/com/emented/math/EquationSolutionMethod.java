package com.emented.math;

import com.emented.dto.AnswerEquation;
import com.emented.dto.InputData;
import com.emented.equation.Equation;

public interface EquationSolutionMethod {

    AnswerEquation solveEquation(Equation equation, InputData interval);

}
