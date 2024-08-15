package org.example.springbootstudy.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {
    @Transactional
    @Async("mailThreadPool")
    @SneakyThrows
    public void sendMail(String email, String message) {
        Thread.sleep(new Random().nextInt(3000));
        log.info("The email to {} has been successfully sent. The message is {}",email, message);

    }

    @Async("mailThreadPool")
    @SneakyThrows
    public CompletableFuture<String> blockSendMail(String email, String message) {
        Thread.sleep(new Random().nextInt(3000));
        log.info("The email to {} has been successfully sent. The message is {}",email, message);
        return CompletableFuture.completedFuture("The email to "+email+" has been successfully sent. The message is "+message);
    }

    @Async("mailThreadPool")
    @SneakyThrows
    public void haha(){
        log.info("haha");
    }
}
