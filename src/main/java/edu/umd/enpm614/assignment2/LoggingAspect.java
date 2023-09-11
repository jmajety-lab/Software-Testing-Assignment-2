package edu.umd.enpm614.assignment2;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class LoggingAspect {



    @Before("execution(* edu.umd.enpm614.assignment2.interfaces.Frontend.*(..)) || execution(* edu.umd.enpm614.assignment2.interfaces.Persistence.*(..))||execution(* edu.umd.enpm614.assignment2.interfaces.Middleware.*(..))")
    public void logPersistence(JoinPoint joinPoint) throws Throwable {
        System.out.println("Logging Aspect: "+joinPoint.getSignature().getDeclaringType().getSimpleName()+"."+joinPoint.getSignature().getName());
    }


}
