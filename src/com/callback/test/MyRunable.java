package com.callback.test;

/**
 * Created by zhang on 2017/2/21.
 */
public class MyRunable implements Runnable{
    private int tickets =1000;
    @Override
    public void run() {
//        for (int i = 0; i < 1000; i++) {
            while (tickets > 0) {
                synchronized (this){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票 :ticket=" + tickets--);
            }
//        }
        }
    }
}
