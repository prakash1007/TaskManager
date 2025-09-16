package com.example.taskmanager.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	
	@Before("execution(* com.example.taskmanager.service.TaskService.*(. .))")
	public void logMethodCalled(JoinPoint jp) {
		LOGGER.info("Method called "+jp.getSignature().getName());
	}
	
	@After("execution(* com.example.taskmanager.service.TaskService.*(. .))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method executed "+jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.example.taskmanager.service.TaskService.*(. .))")
	public void logMethodCrash(JoinPoint jp) {
		LOGGER.info("Method has some issues with"+ jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.example.taskmanager.service.TaskService.*(. .))")
	public void logMethodSucceed(JoinPoint jp) {
		LOGGER.info("Method has called successfully"+ jp.getSignature().getName());
	}

}
