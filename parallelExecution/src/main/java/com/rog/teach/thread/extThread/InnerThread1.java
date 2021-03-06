package com.rog.teach.thread.extThread;

public class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(this);
                    if(--countDown == 0){
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }
    public InnerThread1(String name){
        inner = new Inner(name);
    }
}
