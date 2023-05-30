package com.emented.data;

import java.util.List;

import com.emented.dto.BigInterval;
import com.emented.dto.InputData;
import com.emented.equation.Equation;
import com.emented.math.EquationSolutionMethod;
import com.emented.system.SystemTask;


public class GlobalStore {
    public static Equation equation;
    public static InputData data;
    public static EquationSolutionMethod method;
    public static BigInterval interval;
    public static List<InputData> intervals;
    public static SystemTask system;
    public static boolean isSystem;
    public static boolean isFile;
    public static boolean isOutputFile;
}
