package org.cbu.cse3111.mc.environment;

import aima.core.agent.Action;
import aima.core.search.framework.problem.*;

public class MCProblem extends Problem {
    MCProblem() {
        super();
    }

    public MCProblem(Object initialState, ActionsFunction actionsFunction, ResultFunction resultFunction, GoalTest goalTest) {
        super(initialState, actionsFunction, resultFunction, goalTest);
    }

    public MCProblem(Object initialState, ActionsFunction actionsFunction, ResultFunction resultFunction, GoalTest goalTest, StepCostFunction stepCostFunction) {
        super(initialState, actionsFunction, resultFunction, goalTest, stepCostFunction);
    }
}
