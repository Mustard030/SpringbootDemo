package org.example.springbootstudy.entity;

import org.hibernate.validator.constraints.Length;

public class User2 implements IUser{
    int id;
    @Length(min = 3, max = 10)
    String name;
    String email;
    @Length(min = 10)
    String password;

    @Override
    public void say() {
        System.out.println("say");
    }
}
