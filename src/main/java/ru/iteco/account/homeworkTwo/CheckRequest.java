package ru.iteco.account.homeworkTwo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.account.homeworkTwo.service.ExternalInfo;

@Slf4j
@Component
@Aspect
public class CheckRequest {
    @Value("${id-not-process}") private Integer id;

    @Around("annotationCheckRequest()")
    public void annotationCheckRequestWithExternalInfo(ProceedingJoinPoint proceedingJoinPoint, ExternalInfo externalInfo) throws  Throwable {
        log.info("Check request:{} with {}",proceedingJoinPoint.getSignature().toShortString(),externalInfo);
        if(!id.equals(externalInfo.getId())){
            log.info("ALLOW REQUEST");
            proceedingJoinPoint.proceed();
        }else{throw  new RuntimeException("DECLINE REQUEST");}
    }

    @Pointcut("@annotation(ru.iteco.account.homeworkTwo.CheckRequest) && args(externalInfo, ..)")
    public void annotationCheckRequest() {}
}