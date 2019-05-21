package com.example.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

import org.mockito.internal.matchers.Equals;

public class CopyOfMailController {

    public static void main(String[] args)  {
    	
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
      
    }


}
