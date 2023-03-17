package com.study.springboot.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author liuhao
 * @Date 2023/3/16
 */
public class CglibProxy implements MethodInterceptor {
    private Object bean;
    private Enhancer enhancer = new Enhancer();
    public CglibProxy(Object bean){
        this.bean=bean;
    }

    public Object getProxy(){
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("wakeup")){
            System.out.println("早安~~~");
        }else if(methodName.equals("sleep")){
            System.out.println("晚安~~~");
        }
        return method.invoke(bean,objects);
    }
}
