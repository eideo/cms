package com.sbiao360.sys.performance;

import java.util.Date;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;

import com.sbiao360.sys.performance.domain.SysMethodTimeLog;
import com.sbiao360.sys.performance.service.MethodTimeService;

/**
 * 切面工具类监控方法的执行时间
 * 
 * @author yujunwei
 */
public class MethodTimeAdvice implements MethodInterceptor {

	@Resource
	private MethodTimeService methodTimeService;

	// 拦截要执行的目标方法
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 用 commons-lang 提供的 StopWatch 计时
		StopWatch clock = new StopWatch();
		// 计时开始
		clock.start();
		Object result = invocation.proceed();
		// 计时结束
		clock.stop();

		// 方法参数值
		/*
		 * Object[] objectArr = invocation.getArguments(); if(objectArr != null
		 * && objectArr.length > 0){ for (int i = 0, len = objectArr.length; i <
		 * len; i++) { if (objectArr[i] instanceof String) {
		 * System.out.println("String类型：" + objectArr[i].toString()); } else if
		 * (objectArr[i] instanceof Integer) { System.out.println("Integer类型：" +
		 * objectArr[i].toString()); } else if (objectArr[i] instanceof Long) {
		 * System.out.println("Long类型：" + objectArr[i].toString()); } else {
		 * System.out.println("其他类型：" + objectArr[i]); } } }
		 */

		// 方法参数类型转换成简单类型
		Class<?>[] params = invocation.getMethod().getParameterTypes();
		String[] simpleParams = new String[params.length];

		for (int i = 0; i < params.length; i++) {
			simpleParams[i] = params[i].getSimpleName();
		}

		String execMethod = invocation.getThis().getClass().getName() + "."
				+ invocation.getMethod().getName() + "("
				+ StringUtils.join(simpleParams, ",") + ")";
		Long execTime = clock.getTime();

		// 获取behavior.properties文件中配置的执行时间阈值
		Long timeThreshold = MethodTimeService.timeThreshold;

		// 方法执行时间超过阈值则进行记录操作
		if (execTime.longValue() > timeThreshold.longValue()) {
			SysMethodTimeLog sysMethodTimeLog = new SysMethodTimeLog();
			sysMethodTimeLog.setExecMethod(execMethod);
			sysMethodTimeLog.setExecTime(execTime);
			sysMethodTimeLog.setInsertDate(new Date());

			methodTimeService.insertSysMethodTimeLog(sysMethodTimeLog);

			// System.out.println("[" + execMethod + "] 该方法执行时间: " + execTime + "ms，超过阈值：" + timeThreshold + "ms");
		}

		return result;
	}
}
