package com.emented.math;

import com.emented.dto.AnswerSystem;
import com.emented.dto.BigInterval;
import com.emented.system.SystemTask;

public interface SystemSolutionMethod {
    AnswerSystem solveSystem(BigInterval interval, SystemTask system);
}
