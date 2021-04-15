package com.rog.teach.thread.restoran;

public class Meal {
    private final int order;

    public Meal(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Meal " + order;
    }
}
