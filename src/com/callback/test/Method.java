package com.callback.test;

/**
 * Created by zhang on 2017/2/20.
 */
public class Method {
    public void test(){
        Car myCar = new Car();
        Bus myBus = new Bus();
        Car myCar1 = (Car)myBus;
        myCar.drive();
        Bus myBus1 = (Bus)myCar1;
        myBus1.drive();
        myBus1.drive(1);
        myBus1.carry();
        myBus1.carry(10);
    }
}

class Car{
    public int v = 60;
    String name="Car";
    void Car(int v, String name){
        v = v;
        name = name;
    }
    public void drive(){
        System.out.println(name + "速度: " + v);
    }
}

class Bus extends Car{
    int p = 40;
    public void carry(){
        System.out.println(super.name + "Bus载人: " + p);
    }
    //覆盖父类drive方法
    @Override
    public void drive() {
        System.out.println("override this is Bus drive");
    }
    //重载父类drive方法
    public void drive(int p){
        System.out.println("overwrite this is Bus drive(int p)");
    }
    //重写子类carry方法
    public void carry(int v){
        System.out.println(super.name + "Bus载人: " + v);
    }
    void sum(){
        System.out.println(super.name + "Bus速度: " + super.v);
        System.out.println(super.name + "Bus载人: " + p);
    }
}