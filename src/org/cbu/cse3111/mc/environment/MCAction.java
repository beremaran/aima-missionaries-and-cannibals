package org.cbu.cse3111.mc.environment;


import aima.core.agent.Action;

public class MCAction implements Action {

    private int m;
    private int c;

    public MCAction(int m, int c) {
        this.m = m;
        this.c = c;
    }

    @Override
    public boolean isNoOp() {
        return m == 0 && c == 0;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "<" + m + ", " + c + ">";
    }

    @Override
    public boolean equals(Object obj) {
        MCAction other = (MCAction) obj;
        return other.m == m && other.c == c;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
