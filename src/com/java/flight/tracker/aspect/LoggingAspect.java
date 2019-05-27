package com.java.flight.tracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// setup logger
	private Logger flightLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.java.flight.tracker.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.java.flight.tracker.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.java.flight.tracker.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display method signature
		String method = joinPoint.getSignature().toShortString();
		flightLogger.info("@Before: calling method: " + method);
		// display arguments
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			flightLogger.info("@Before: argument: " + arg);
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		// display method signature
		String method = joinPoint.getSignature().toShortString();
		flightLogger.info("@AfterReturning: from method: " + method);
		// display data returned
		flightLogger.info("@AfterReturning: result: " + result);
	}
	
}
