package com.study.springboot.thread.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author liuhao
 * @Date 2023/3/17
 */
public class Thread1 extends Thread{
    private static final Logger LOG = LoggerFactory.getLogger(Thread1.class);
    private String name;
    public Thread1(String name){
        this.name=name;
    }
    @Override
    public void run(){

        for (int i=0;i<5;i++){
            LOG.info("{}开始执行第{}次",this.name,i);
            try {
                sleep((int)(Math.random()*30));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
