package org.example.springbootstudy.entity;

public class Proxy implements Subject {   //为了保证和Subject操作方式一样，保证透明性，也得继承

    Subject target;   //被代理的对象（甚至可以多重代理）

    public Proxy(Subject subject){
        this.target = subject;
    }

    @Override
    public void test() {   //由代理去执行被代理对象的方法，并且我们还可以在前后添油加醋
        System.out.println("代理前绕方法");
        target.test();
        System.out.println("代理后绕方法");
    }
}
