package com.example.customize.util;

import com.example.customize.annotation.CustomLog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LogUtil {

    @CustomLog(level = CustomLog.Level.DEBUG)
    public static void print() {
        System.out.println("print in method");
    }

    private void getLog(Object object) throws Exception {

        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CustomLog.class)) {

                CustomLog customLog = method.getDeclaredAnnotation(CustomLog.class);
                System.out.println("log level is "+customLog.level());
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

}
