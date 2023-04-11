package com.study.springboot.thread;

import com.study.springboot.thread.thread.Thread1;

/**
 * @Author liuhao
 * @Date 2023/3/17
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("A");
        Thread1 thread2 = new Thread1("B");

        thread2.start();
        thread1.start();

    }
}
