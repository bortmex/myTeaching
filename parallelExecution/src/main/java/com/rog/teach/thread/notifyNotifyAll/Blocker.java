package com.rog.teach.thread.notifyNotifyAll;

public class Blocker {
    synchronized void waitingCall(){
        try {
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        }catch (InterruptedException e){
            //Допустимый способ выхода
        }
    }
    public synchronized void prod(){
        notify();
    }
    public synchronized void prodAll(){
        notifyAll();
    }
}
