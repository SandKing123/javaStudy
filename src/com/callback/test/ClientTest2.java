package com.callback.test;

/**
 * Created by zhang on 2017/2/20.
 */
public class ClientTest2 implements IFileIOCallback{
    public void saveStr() {
        String fileName = "callback2.txt";
        String str = "this is ClientTest2\r\n";
        ctrlFile fileIO = new ctrlFile();
        boolean isSave = fileIO.saveStrToFile(fileName, str, this);
//        System.out.println(isSave ? "保存成功" : "保存失败");
    }
    public void onResult(boolean isSave){
        System.out.println(isSave ? "callback2 保存成功" : "callback2 保存失败");
    }
}

class ClientTest3 implements IFileIOCallback{
    public void saveStr() {
        String fileName = "callback3.txt";
        String str = "this is ClientTest3\r\n";
        ctrlFile fileIO = new ctrlFile();
        boolean isSave = fileIO.saveStrToFile(fileName, str, this);
//        System.out.println(isSave ? "保存成功" : "保存失败");
    }
    public void onResult(boolean isSave){
        System.out.println(isSave ? "callback3 保存成功" : "callback3 保存失败");
    }
}