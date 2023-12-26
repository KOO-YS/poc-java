package com.example.plan.service;

import org.apache.tomcat.util.file.Matcher;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service

public class CustomerService {


    public boolean validateName(String firstName, String lastName) {
        String kr = "^[ㄱ-ㅎ|가-힣]+$";
        String eng = "^[a-z|A-Z]+$";

        return (validLanguage(kr, firstName) && validLanguage(kr, lastName))
                || (validLanguage(eng, firstName) && validLanguage(eng, lastName));
    }

    /**
     *
     * @param regex 기준 정규 표현식
     * @param str 체크할 문자열
     * @return 적합 여부
     */
    private boolean validLanguage(String regex, String str) {
        return Pattern.matches(regex, str);
    }
}
