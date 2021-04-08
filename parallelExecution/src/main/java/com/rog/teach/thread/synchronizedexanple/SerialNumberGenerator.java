package com.rog.teach.thread.synchronizedexanple;

public class SerialNumberGenerator {
    private static int serialNumber = 0;
    public synchronized static int nextSerialNumber(){ //<-- synchronized оч важно
        return serialNumber++;
    }
}
