package com.callback.test;

import java.time.Clock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhang on 2017/2/21.
 * java 静态类  匿名类  内部类  异常类
 */
public class ObjExtend {
    public void test(){
        StaticClass.inc("this is staticClass");
        StaticClass.InnerClass staticInner = new StaticClass.InnerClass();
        staticInner.inner("this is static Inner");

        RunnableCounting runnableTest1 = new RunnableCounting();
        runnableTest1.test();
    }
}

class StaticClass{
    public static class InnerClass{
        InnerClass(){
            System.out.println("InnerClass");
        }
        public void inner(String str){
            System.out.println(str);
        }
    }
    public class NoName extends Thread{
        public void run(){
            System.out.println("this is NoName thread");
        }
    }
    public class NoName1 implements Runnable{
        public void run(){
            System.out.println("this is NoName thread");
        }
    }
    public static void inc(String str){
        System.out.println(str);
    }
}

//线程同步问题  这里没有对共享资源同步 注意 synchronized 使用

class MyRunnable implements Runnable{
    private int tickets =100;
    private Lock lock;
    MyRunnable(Lock _lock){
        lock = _lock;
    }
    @Override
    public void run() {
                while (tickets > 0) {
                    try{
                        lock.lock();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if( tickets > 0)
                        System.out.println(Thread.currentThread().getName() + "卖票 :ticket=" + tickets--);
                }finally {
                        lock.unlock();
                    }
        }
    }
}
class RunnableCounting {
    public static final Object obj = new Object();
    ReentrantLock lock;
    RunnableCounting(){
        lock = new ReentrantLock();
    }
    public void test() {
        MyRunnable r = new MyRunnable(lock);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }

}
