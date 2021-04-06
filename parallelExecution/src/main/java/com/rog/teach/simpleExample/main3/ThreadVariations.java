package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.ThreadMethod;
import com.rog.teach.thread.extThread.InnerThread1;
import com.rog.teach.thread.extThread.InnerThread2;
import com.rog.teach.thread.impRunnable.InnerRunnable1;
import com.rog.teach.thread.impRunnable.InnerRunnable2;

public class ThreadVariations {
    public static void main(String[] args) {
        //именнованный внутренний класс
        new InnerThread1("InnerThread1");
        //анонимный внутренний класс
        new InnerThread2("InnerThread2");
        //именнованная реализация Runnable
        new InnerRunnable1("InnerRunnable1");
        //анонимная реализация Runnable
        new InnerRunnable2("InnerRunnable2");
        //отдельный метод для выполнения кода в виде задачи
        new ThreadMethod("ThreadMethod").runTask();

    }
}
