package com.rog.teach.replaceMethod;

public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "<hl>" + msg + "</hl>";
    }

    public String formatMessage(Object msg) {
        return "<h2>" + msg + "</h2>";
    }
}