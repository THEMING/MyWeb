package com.ming.util;

import net.sf.json.JSONObject;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.InitializingBean;

import com.ming.domain.ErrorObject;

@Aspect
public class Interceptor implements MethodInterceptor,InitializingBean,Advice{

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {System.out.println("===============À¹½Ø==");
		Object result = null;
		try{
			result = invocation.proceed();
		}catch(Exception e){
			ErrorObject eo = new ErrorObject(e.getMessage());
			return JSONObject.fromObject(eo).toString();
		}
		
		return result;
	}
	
//	@Before(value = "execution(* com.ming.service.*.addUser(..))")
//	@Before(value = "execution(* *(..)) && @annotation(com.ming.annotation.MyAnnotation)")
	@Before(value = "execution(* com.ming.service.*.*(..))")
	public void testInterceptor(){
		System.out.println("=================testInterceptor=============");
	}
//	
//	@Around(value = "execution(* *(..)) && @annotation(com.ming.annotation.MyAnnotation)")
//	public Object testAroundInterceptor(ProceedingJoinPoint pjp){
//		System.out.println("=================testAroundInterceptor=============");
//		try {
//			return pjp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

}
