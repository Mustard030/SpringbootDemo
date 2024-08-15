package org.example.springbootstudy.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@Tag(name="异步接口", description = "异步请求发送邮件")
public class AsyncController {
    @Resource
    private AsyncService asyncService;

    @SneakyThrows
    @GetMapping("/sendMails")
    @Operation(summary = "异步发送邮件", description = "非阻塞接口")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "500", description = "请求失败")
    })
    public String sendMails(@Parameter(description = "邮件列表", example = "{\"a1@163.com\", \"a2@163.com\"}") String[] emails) {
        CompletableFuture<String>[] futures = new CompletableFuture[5];

//        String[] emails = new String[]{"a1@163.com", "a2@163.com", "a3@163.com", "a4@163.com", "a5@163.com",};
        for (String email : emails) {
            asyncService.sendMail(email, "Sample text");
        }

        return "SUCCESS";
    }

    @SneakyThrows
    @GetMapping("/blockSendMails")
    @Operation(summary = "异步阻塞发送邮件", description = "阻塞接口")
    public String blockSendMails() {
        CompletableFuture<String>[] futures = new CompletableFuture[5];

        String[] emails = new String[]{"a1@163.com", "a2@163.com", "a3@163.com", "a4@163.com", "a5@163.com",};
        for (int i = 0; i < emails.length; i++) {
            futures[i] = asyncService.blockSendMail(emails[i], "Sample text");
        }
        //阻塞等待所有CompletableFuture响应结果
        CompletableFuture.allOf(futures);

        StringBuffer out = new StringBuffer();
        for (CompletableFuture<String> future : futures) {
            try {
                out.append(future.get() + "\n");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return out.toString();
    }

}
