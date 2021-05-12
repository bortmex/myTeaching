package com.rog.teach.nativeExample;

public class HelloWorld {
    //http://fizyka.umk.pl/~jacek/docs/javatutorial/native1.1/stepbystep/index.html
    public native void displayHelloWorld();

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}
