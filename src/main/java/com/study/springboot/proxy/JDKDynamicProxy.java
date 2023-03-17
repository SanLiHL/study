package com.study.springboot.proxy;

import com.study.springboot.proxy.entry.Animal;
import com.study.springboot.proxy.entry.impl.Cat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * @Author liuhao
 * @Date 2023/3/16
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object bean;

    //生成代理对象
    public Object newProxyInstance(Cat cat){
        this.bean=cat;
        return Proxy.newProxyInstance(Cat.class.getClassLoader(),new Class[]{Animal.class},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        //增强
        if ("wakeup".equals(methodName)){
            System.out.println("早安~~");
        }else if ("sleep".equals(methodName)){
            System.out.println("午安~~~");
        }
        //执行原来的操作
        return method.invoke(bean,args);
    }
}
