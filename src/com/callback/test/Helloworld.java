package com.callback.test;

/**
 * Created by zhang on 2016/12/10.
 */
public class Helloworld {
    final String hello = "Hello,";
    public void tosay(){
//        toSayOne();
//        toSayTwo();
//        toSayThree();
    }
    public void toSayOne(){
        String world = "World";
        System.out.println(this.hello + world);
    }
    public void toSayTwo(){
        String world = "China";
        System.out.println(this.hello + world);
    }
    public void toSayThree(){
        Integer b = new Integer(21);

        System.out.println(b.floatValue());
        System.out.println(b.hashCode());
        System.out.println(b.intValue());
    }
}
