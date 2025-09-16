package com.example.taskmanager.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("execution(* com.example.taskmanager.service.TaskService.getTaskById.(. .)) && args(ID)")
	private Object validateAndUpdate(ProceedingJoinPoint jp,int id) throws Throwable {
		if(id<0)
		{
			LOGGER.info("Id is negative. Updating it");
			id=-1;
			LOGGER.info("Id has been changed to : "+id);
		}
		Object proceed = jp.proceed(new Object[] {id});
		return proceed;
		// TODO Auto-generated method stub

	}
}
