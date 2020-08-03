package com.surya.springboot.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyDemoLoggingAspect.class); 
	
	@Around("com.surya.springboot.demo.aspect.AspectExpressions.forRestPackage()")
	public Object profileAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		//get intercepted method details
		String declaringClassName = signature.getDeclaringTypeName();
		String methodName  = signature.getName();
		
		final StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object proceed = joinPoint.proceed();
		
		stopWatch.stop();
		
		LOGGER.info("Execution time of " + declaringClassName + "." + methodName +  
				                             ":: " + stopWatch.getTotalTimeMillis() + " ms");
		
		return proceed;
		
		
	}

}
