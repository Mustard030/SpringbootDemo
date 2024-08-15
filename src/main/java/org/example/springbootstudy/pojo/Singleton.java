package org.example.springbootstudy.pojo;

public class Singleton implements Cloneable{
    private static volatile Singleton INSTANCE;   //在一开始先不进行对象创建

    private Singleton() {}

    public static Singleton getInstance(){
        if(INSTANCE == null) {
            synchronized (Singleton.class) {
                if(INSTANCE == null) INSTANCE = new Singleton();  //内层还要进行一次检查，双重检查锁定
            }
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}