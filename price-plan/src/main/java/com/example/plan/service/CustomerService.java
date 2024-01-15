package com.example.plan.service;

import org.apache.tomcat.util.file.Matcher;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CustomerService {

    private static final Pattern VALID_KOR = Pattern.compile("^[ㄱ-ㅎ|가-힣]+$");
    private static final Pattern VALID_ENG = Pattern.compile("^[a-z|A-Z]+$");

    public boolean validateName(String firstName, String lastName) {
        return ((VALID_KOR.matcher(firstName).matches() && VALID_KOR.matcher(lastName).matches())
            || (VALID_ENG.matcher(firstName).matches() && VALID_ENG.matcher(lastName).matches()));
    }
}
