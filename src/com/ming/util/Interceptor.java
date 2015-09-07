package com.ming.util;

import net.sf.json.JSONObject;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;

import com.ming.domain.ErrorObject;

public class Interceptor implements MethodInterceptor,InitializingBean,Advice{

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		try{
			result = invocation.proceed();
		}catch(Exception e){
			ErrorObject eo = new ErrorObject(e.getMessage());
			return JSONObject.fromObject(eo).toString();
		}
		
		return result;
	}

}
