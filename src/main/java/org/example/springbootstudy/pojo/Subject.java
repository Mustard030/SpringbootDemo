package org.example.springbootstudy.pojo;


import java.util.HashSet;
import java.util.Set;

public class Subject {
    private final Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void modify(){   //模拟对象进行修改
        observers.forEach(Observer::update);
    }
}
