package com.codegym.picture.logger;

import com.codegym.picture.model.entity.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Target;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution( * com.codegym.picture.model.service.impl.CommentServiceImpl.save(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
        Object[] signatureArgs = joinPoint.getArgs();
        Comment comment=null;
        for(Object o : signatureArgs){
            comment = (Comment) o;
        }
        String date = LocalDate.now().toString();
        System.err.println(String.format("[CMS] co loi xay ra- %s:%s - loi:%s- time:%s", comment.getAuthor(), comment.getFeedback(),e.getMessage(),date));
    }
}
