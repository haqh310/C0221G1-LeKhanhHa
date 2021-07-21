package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }


}
