package com.callback.test;

/**
 * Created by zhang on 2017/2/20.
 */
public class ClientTest1 extends Client{
    public void saveStr() {
        String fileName = "callback1.txt";
        String str = "this is ClientTest1\n";
        ctrlFile fileIO = new ctrlFile();
        boolean isSave = fileIO.saveStrToFile(fileName, str, this);
//        System.out.println(isSave ? "ClientTest1保存成功" : "ClientTest1保存失败");
    }
    public void onResult(boolean isSave){
        System.out.println(isSave ? "callback1保存成功" : "callback1保存失败");
    }
}