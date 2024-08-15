package org.example.springbootstudy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springDocOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("XXXXX管理系统")
                .description("后端API文档，欢迎查阅")
                .version("2.0")
                .license(new License()
                        .name("我的个人主页")
                        .url("https://github.com/Mustard030")
                )
        );
    }
}
