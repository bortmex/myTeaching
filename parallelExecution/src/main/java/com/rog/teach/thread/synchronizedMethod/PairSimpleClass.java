package com.rog.teach.thread.synchronizedMethod;

public class PairSimpleClass {
    private int x, y;

    public PairSimpleClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PairSimpleClass() {
        this(0, 0);
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + PairSimpleClass.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
