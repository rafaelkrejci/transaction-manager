package br.com.krejci.transactionmanager.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogginByAspects {

    @Around("execution(* br.com.krejci.transactionmanager.adapter.inbound.rest..*Controller.*(..))")
    public Object logInputs(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Method parameters: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + "."
                + joinPoint.getSignature().getName() + "(" + Arrays.toString(joinPoint.getArgs()) + ")");

        Object retVal = joinPoint.proceed();
        log.info("returning {} ", retVal);
        return retVal;
    }

}