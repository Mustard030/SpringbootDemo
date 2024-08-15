package org.example.springbootstudy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

@Data
@Service
public class User1 implements IUser{
    @TableId(type = IdType.AUTO)
    Integer id;
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

