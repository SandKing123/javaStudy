package com.callback.test;

/**
 * Created by zhang on 2017/2/18.
 */
public class zhang {
    public void saveStr() {
        String fileName = "callback.txt";
        String str = "这是一个普通的例子。\n";
        ctrlFile fileIO = new ctrlFile();
        boolean isSave = fileIO.saveStrToFile(fileName, str, this);
//        System.out.println(isSave ? "保存成功" : "保存失败");
    }
    public void onResult(boolean isSave){
        System.out.println(isSave ? "zhang保存成功" : "zhang保存失败");
    }

    public void testAll(){
        saveStr();
        ClientTest1 test1 = new ClientTest1();
        test1.saveStr();
        ClientTest2 test2 = new ClientTest2();
        test2.saveStr();
        ClientTest3 test3 = new ClientTest3();
        test3.saveStr();
    }
}
