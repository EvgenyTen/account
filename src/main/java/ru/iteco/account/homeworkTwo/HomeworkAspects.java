package ru.iteco.account.homeworkTwo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class HomeworkAspects {
    @Before("allMethods")
    public void beforeAllMethods(JoinPoint joinPoint) {
        log.info("Before all methods in service::START {}", joinPoint.getSignature().toShortString());
    }

    @After("allMethods")
    public void afterAllMethods(JoinPoint joinPoint) {
        log.info("After all methods in service::FINISH {}", joinPoint.getSignature().toShortString());
    }

    @Pointcut("within(ru.iteco.account.homeworkTwo.service.*)")
    public void allMethods() {}
}
