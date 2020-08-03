package com.surya.springboot.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;


public class AspectExpressions {
	
	//pointcut expression : execution(modifier-pattern? return-type-pattern declaring-type-pattern?
			//                      method-name-pattern(param-pattern) throws-pattern?)
			
			//The pattern is optional if it has "?"
			//For the pattern, can use wildcard: * (matches on everything)
			
			//For param-pattern : () matches no arg method, (*) matches one arg method of any type and 
			//                    (..) matches 0 or more arg method of any type
			
	/*
	 * @Pointcut("execution(* com.surya.aopdemo.dao.*.*(..))") public void
	 * forDaoPackage() {}
	 * 
	 * @Pointcut("execution(* com.surya.aopdemo.dao.*.set*(..))") public void
	 * forSetter() {}
	 * 
	 * @Pointcut("execution(* com.surya.aopdemo.dao.*.get*(..))") public void
	 * forGetter() {}
	 * 
	 * //combining
	 * 
	 * @Pointcut("forDaoPackage() && !(forSetter() || forGetter())") public void
	 * forDaoPackageNoGetterSetter() {}
	 */ 
	
	
		@Pointcut("execution(* com.surya.springboot.demo.rest.*.*(..))")
		public void	 forRestPackage() {}
	
			

}
