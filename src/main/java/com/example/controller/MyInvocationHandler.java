package com.example.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyInvocationHandler implements InvocationHandler{
		
		//代理对象
		ArrayList target = new ArrayList();
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//前置通知
			System.out.println("方法调用前:" + method.getName());
			//代理对象方法调用
			Object o = method.invoke(target, args);
			//后置通知
			System.out.println("方法调用后:" + method.getName());
			return o;
		}
}
