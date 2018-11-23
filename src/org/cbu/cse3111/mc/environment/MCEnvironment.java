package org.cbu.cse3111.mc.environment;

public class MCEnvironment {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private int ml;
    private int cl;
    private int mr;
    private int cr;
    private int b;

    public MCEnvironment() {
        this(3, 3, 0, 0, LEFT);
    }

    public MCEnvironment(int ml, int cl, int mr, int cr, int b) {
        this.ml = ml;
        this.cl = cl;
        this.mr = mr;
        this.cr = cr;
        this.b = b;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public int getMr() {
        return mr;
    }

    public void setMr(int mr) {
        this.mr = mr;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format(
                "<%d, %d, %d, %d, %s>",
                ml, cl, mr, cr, b == LEFT ? "left" : "right"
        );
    }

    @Override
    public boolean equals(Object obj) {
        MCEnvironment o = (MCEnvironment) obj;
        return o.getMl() == getMl() && o.getMr() == getMr() &&
                o.getCl() == getCl() && o.getCr() == getCr() &&
                o.getB() == getB();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
