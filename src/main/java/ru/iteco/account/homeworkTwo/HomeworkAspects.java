package ru.iteco.account.homeworkTwo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class HomeworkAspects {
    @Before("allMethods()")
    public void beforeAllMethods(JoinPoint joinPoint) {
        log.info("Before all methods in service::START {}", joinPoint.getSignature().toShortString());
    }

    @After("allMethods()")
    public void afterAllMethods(JoinPoint joinPoint) {
        log.info("After all methods in service::FINISH {}", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(value="allMethods()", throwing = "exception")
    public void afterAllMethodsWithThrow(JoinPoint joinPoint, Exception exception){
        log.info("Finish {}  with throw: {}",joinPoint.getSignature().toShortString(),exception.toString());
    }

    @Pointcut("within(ru.iteco.account.homeworkTwo.service.*)")
    public void allMethods() {}
}
