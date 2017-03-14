package com.callback.test;

import java.io.*;

/**
 * Created by zhang on 2017/2/18.
 */
class IOFile{
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
abstract class Client{
    public  abstract void onResult(boolean isSave);
}
interface IFileIOCallback {
    void onResult(boolean isSave);
}

public class ctrlFile {
    public File getExistsFile(final String fileName){
        File file = new File(fileName);
        if( !file.exists() ) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public boolean saveStrToFile(final String fileName, String content, zhang temp){
        new Thread( new Runnable() {
            @Override
            public void run() {
                File file = getExistsFile(fileName);
                try {
                    FileWriter writer = new FileWriter(file.getName(), true);
                    BufferedWriter bfWrite = new BufferedWriter(writer);
                    bfWrite.write(content);
                    bfWrite.close();
                    temp.onResult(true);
                } catch (IOException e) {
                    temp.onResult(false);
                    e.printStackTrace();
                }
            }
        }).start();
        return true;
    }
    public boolean saveStrToFile(final String fileName, String content, Client temp){
        new Thread( new Runnable() {
            @Override
            public void run(){
                File file = getExistsFile(fileName);
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter writer = new FileWriter(file.getName(), true);
                    BufferedWriter bfWrite = new BufferedWriter(writer);
                    bfWrite.write(content);
                    bfWrite.close();
                    temp.onResult(true);
                } catch (IOException e) {
                    temp.onResult(false);
                    e.printStackTrace();
                }
            }
        }).start();
        return true;
    }
    public boolean saveStrToFile(final String fileName, String content, IFileIOCallback temp){
        new Thread( new Runnable() {
            @Override
            public void run() {
                File file = getExistsFile(fileName);
                try {
                    FileWriter writer = new FileWriter(file.getName(), true);
                    BufferedWriter bfWrite = new BufferedWriter(writer);
                    bfWrite.write(content);
                    bfWrite.close();
                    temp.onResult(true);
                } catch (IOException e) {
                    temp.onResult(false);
                    e.printStackTrace();
                }
            }
        }).start();
        return true;
    }
}
