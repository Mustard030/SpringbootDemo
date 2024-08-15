package org.example.springbootstudy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@RedisHash("Student")
@NoArgsConstructor
public class Student implements Serializable {
    public enum Gender{
        MALE,FEMALE;
    }

    @Id
    private String id;
    private String name;
    private Gender gender;
    private Integer grade;
    private List<Book> books = new ArrayList<>();

    public Student(String id, String name, Gender gender, Integer grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }
}
