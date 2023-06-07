package com.example.customize;

import com.example.customize.annotation.CustomLog;
import com.example.customize.util.LogUtil;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
public class AnnotationCustomizeApplication {


    public static void main(String[] args) {

        SpringApplication.run(AnnotationCustomizeApplication.class, args);

        Method[] methods = LogUtil.class.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(CustomLog.class)) {

                CustomLog customLog = method.getDeclaredAnnotation(CustomLog.class);
                System.out.println("log level is "+customLog.level());
            }
        }

        LogUtil.print();
    }
}
