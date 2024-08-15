package org.example.springbootstudy.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.entity.User1;
import org.example.springbootstudy.mapper.User1Mapper;
import org.example.springbootstudy.myinterface.MethodExporter;
import org.example.springbootstudy.pojo.Person;
import org.example.springbootstudy.service.AsyncService;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Validated
public class TestController {

    User1Mapper mapper;

    AsyncService asyncService;

    public TestController(User1Mapper mapper, AsyncService asyncService) {
        this.mapper = mapper;
        this.asyncService = asyncService;
    }

    @GetMapping("/")
    @MethodExporter
    public List<Person<BigDecimal>> index() {
        List<Person<BigDecimal>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person<BigDecimal> bigDecimalPerson = new Person<>();
            bigDecimalPerson.setValue(new BigDecimal(i));
            list.add(bigDecimalPerson);
        }

        return list;
    }



    @PostMapping("/submit")
    public String submit(@Length(min=3, max=20) String username,
                         @Length(min=10) String password){
        //do something
        return "请求成功";
    }

    @PostMapping("/submit_class")
    public String submitClass(@Valid User1 user1){
        //do something
        return "请求成功";
    }

    @GetMapping("/upload")
    public String upload(String name, @RequestPart("myfile")MultipartFile file) throws IOException {
        //保存文件
        file.transferTo(new File("D:\\your\\filepath.png"));
        return "OK";
    }

    @GetMapping("/path/{id}")
    public String pathParam(@PathVariable("id") Integer id) {
        return "forward:/index.html";
//        return "redirect:/index.html";
    }
}
