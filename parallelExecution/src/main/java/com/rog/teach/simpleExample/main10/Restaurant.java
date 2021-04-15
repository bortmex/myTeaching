package com.rog.teach.simpleExample.main10;

import com.rog.teach.thread.restoran.Chef;
import com.rog.teach.thread.restoran.Meal;
import com.rog.teach.thread.restoran.WaitPerson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    public Meal meal;
    public ExecutorService exec = Executors.newCachedThreadPool();
    public final WaitPerson waitPerson = new WaitPerson(this);
    public final Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
