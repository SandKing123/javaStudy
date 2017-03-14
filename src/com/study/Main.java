package com.study;
import com.callback.test.*;
import com.sun.deploy.util.SyncAccess;

import java.util.concurrent.locks.ReentrantLock;
import com.callback.test.ObjExtend;
//import com.callback.test.zhang;
//import com.callback.test.ClientTest1;
//import com.callback.test.ClientTest2;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.printf("Hello World"+"!");
//        Helloworld inst = new Helloworld();
//        for(int i=0; i<args.length; ++i){
//            System.out.println(args[i]);
//        }
//        inst.tosay();
        //回调test
//        new zhang().testAll();
        //方法  覆盖 重载 重写
//        new Method().test();
        //静态类
        System.out.println("Main方法的优先级为:"+Thread.currentThread().getPriority());//主方法的优先级为NORM_PRIORITY
//        ReentrantLock lock = new ReentrantLock();
//        new ObjExtend().test();

        MyRunable r = new MyRunable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
