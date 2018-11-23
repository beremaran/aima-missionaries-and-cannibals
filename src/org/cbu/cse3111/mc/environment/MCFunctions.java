package org.cbu.cse3111.mc.environment;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.ResultFunction;
import aima.core.search.framework.problem.StepCostFunction;

import java.util.*;

public class MCFunctions {

    public static MCProblem createMCProblem() {
        return new MCProblem(
                getInitalState(),
                getActionsFunction(),
                getResultFunction(),
                getGoalTest(),
                getUniformCostFunction()
        );
    }

    public static HeuristicFunction getHeuristicFunction() {
        return state -> {
            MCEnvironment s = (MCEnvironment) state;
            return h1(s);
        };
    }

    protected static double h1(MCEnvironment s) {
        return (s.getMr() / (double) s.getCr());
    }

    public static MCEnvironment getInitalState() {
        return new MCEnvironment();
    }

    public static GoalTest getGoalTest() {
        return state -> {
            if (!(state instanceof MCEnvironment))
                throw new RuntimeException("state is not a MCEnvironment instance!");

            MCEnvironment env = (MCEnvironment) state;

            return env.getMl() == 0 && env.getCl() == 0 &&
                    env.getMr() == 3 && env.getCr() == 3;
        };
    }

    public static ActionsFunction getActionsFunction() {
        return s -> {
            Set<Action> actionSet = new HashSet<>();
            MCEnvironment state = (MCEnvironment) s;

            int m;
            int c;

            if (state.getB() == MCEnvironment.LEFT) {
                m = state.getMl();
                c = state.getCl();
            } else {
                m = state.getMr();
                c = state.getCr();
            }

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= c; j++) {
                    if (i + j == 0 || i + j > 2)
                        continue;

                    actionSet.add(new MCAction(i, j));
                }
            }

            return actionSet;
        };
    }

    public static ResultFunction getResultFunction() {
        return (s, a) -> {
            if (!(s instanceof MCEnvironment))
                throw new RuntimeException("s is not a MCEnvironment instance!");
            if (!(a instanceof MCAction))
                throw new RuntimeException("a is not a MCAction instance!");

            MCAction action = (MCAction) a;
            MCEnvironment state = (MCEnvironment) s;

            int m_a = action.getM();
            int m_c = action.getC();

            MCEnvironment newState = new MCEnvironment();

            int direction = 1;
            if (state.getB() == MCEnvironment.LEFT) {
                newState.setB(MCEnvironment.RIGHT);
            } else {
                direction = -1;
                newState.setB(MCEnvironment.LEFT);
            }

            newState.setMl(state.getMl() - m_a * direction);
            newState.setMr(state.getMr() + m_a * direction);
            newState.setCl(state.getCl() - m_c * direction);
            newState.setCr(state.getCr() + m_c * direction);

            return newState;
        };
    }

    public static StepCostFunction getUniformCostFunction() {
        return (s, a, sDelta) -> 1;
    }
}
