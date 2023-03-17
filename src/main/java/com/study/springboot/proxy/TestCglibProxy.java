package com.study.springboot.proxy;

import com.study.springboot.proxy.entry.impl.Dog;

/**
 * @Author liuhao
 * @Date 2023/3/16
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        //生成字节码文件的位置
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\aop");
        CglibProxy cglibProxy = new CglibProxy(new Dog("蕾蕾"));
        Dog dog = (Dog)cglibProxy.getProxy();
        dog.sleep();
        dog.wakeup();
    }
}
