package com.example.borrowbookapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private int countLog = 0;

    @AfterReturning("execution(* com.example.borrowbookapp.service.IBorrowCardService.delete(..))")
    public void getLogReturnBook() {
        logger.info("Return book successfully");
    }

    @AfterReturning("execution(* com.example.borrowbookapp.service.IBorrowCardService.add(..))")
    public void getLogBorrow() {
        logger.info("Borrow book successfully");
    }

    @Before("execution(* com.example.borrowbookapp.controller.BookController.*(..))")
    public void getLog() {
        countLog++;
        logger.info("Views: " + countLog);
    }
}
