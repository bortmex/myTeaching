package com.rog.teach.replaceMethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object arg0, Method method, Object[] objects) throws Throwable {
        if(isFormatMessageMethod(method)){
            String msg = (String) objects[0];
            return "Замена реализации";
        } else {
            throw new IllegalAccessException("Метод для замены не найден.");
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }
        if (method.getReturnType() != String.class) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}
