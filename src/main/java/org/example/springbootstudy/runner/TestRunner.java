package org.example.springbootstudy.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Slf4j
//@Component
public class TestRunner implements ApplicationRunner {
//  在项目启动后执行
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("我是自定义执行");
    }
}
