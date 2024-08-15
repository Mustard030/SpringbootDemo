package org.example.springbootstudy.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder)  {
        // 保留Springboot中的自动配置
        ObjectMapper objectMapper = builder
                .timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                .build();
        objectMapper.findAndRegisterModules();  // 核心，下面的按需添加

        SimpleModule module = new SimpleModule();
        //Long类型的反序列化器，防止丢失精度
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Double.class, ToStringSerializer.instance);
        module.addSerializer(Double.TYPE, ToStringSerializer.instance);

        module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        // module.addSerializer(LocalDateTime.class, new LocalDateTimeJsonComponent.MyLocalDateTimeSerializer());
        // module.addDeserializer(LocalDateTime.class, new LocalDateTimeJsonComponent.MyLocalDateTimeDeserializer());
        // module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // module.addDeserializer(LocalDateTime.class, new MyLocalDateTimeDeserializer());

        objectMapper.registerModule(module);

        // 在序列化时，忽略值为 null 的属性
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 在反序列化时，忽略在 json 中存在但 Java 对象不存在的属性。
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }
}