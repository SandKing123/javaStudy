package com.design.pattern;

import java.io.IOException;

/**
 * Created by zhang on 2017/2/28.
 */
public class FactoryPattern {
    public void test(){
        Human human = HumanFactory.createHuman("man");
        human.eat();

        try {
            FemaleHumanFactoryAb hf = new FemaleHumanFactoryAb();
            Human female = hf.createHuman("female");
            female.eat();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

abstract class Human{
    public abstract void eat();
    public abstract void sleep();
    public abstract void beat();
}

class  Man extends Human{
    public void eat(){
        System.out.println("Man can eat.");
    }
    public void sleep(){
        System.out.println("Man can sleep.");
    }
    public void beat(){
        System.out.println("Man can beat.");
    }
}

class  Female extends Human{
    public void eat(){
        System.out.println("Female can eat.");
    }
    public void sleep(){
        System.out.println("Female can sleep.");
    }
    public void beat(){
        System.out.println("Female can beat.");
    }
}

//简单工厂
class HumanFactory{
    public static Human createHuman(String gender){
        Human human = null;
        if( gender == "man "){
            human = new Man();
        }else if( gender.equals("female") ){
            human = new Female();
        }
        return human;
    }
}

//工厂方法模式在简单工厂模式的基础之上，把简单工厂抽象化了。
abstract class HumanFactoryAb{
    public abstract Human createHuman(String gender) throws IOException;
}
class ManHumanFactoryAb extends HumanFactoryAb{
    public Human createHuman(String gender) throws IOException{
        return new Man();
    }
}
class FemaleHumanFactoryAb extends HumanFactoryAb{
    public Human createHuman(String gender) throws IOException{
        return new Female();
    }
}