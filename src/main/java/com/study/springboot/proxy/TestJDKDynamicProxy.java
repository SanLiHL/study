package com.study.springboot.proxy;

import com.study.springboot.proxy.entry.Animal;
import com.study.springboot.proxy.entry.impl.Cat;


/**
 * @Author liuhao
 * @Date 2023/3/16
 */
public class TestJDKDynamicProxy {

    public static void main(String[] args) {
        Animal cat = (Animal) new JDKDynamicProxy().newProxyInstance(new Cat("哈哈"));
        cat.sleep();
        cat.wakeup();
    }

}
