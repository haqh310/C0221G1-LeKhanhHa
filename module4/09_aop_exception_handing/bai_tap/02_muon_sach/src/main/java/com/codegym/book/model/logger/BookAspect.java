package com.codegym.book.model.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int number = 0;

    @AfterReturning(value = "execution(* com.codegym.book.model.service.IManagementBookService.*(..))")
    public void logChange(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String date = LocalDate.now().toString();
        System.err.println(String.format("[CMS] trạng thái sách của thư viện bị thay đổi: %s.%s: %s - time:%s", className, method, args, date));
        logger.error("ten phuong thuc", method);
        logger.error("noi dung", args);
    }

    @After(value = "within(com.codegym.book.model.service..*)")
    public void logNum(JoinPoint joinPoint) {
        number++;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String date = LocalDate.now().toString();
        System.err.println(String.format("[CMS] có %d người đã ghé thăm: %s.%s: %s - time:%s", number, className, method, args, date));
    }
}
