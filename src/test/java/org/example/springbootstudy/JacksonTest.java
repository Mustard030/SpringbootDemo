package org.example.springbootstudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.example.springbootstudy.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JacksonTest {
    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void test1() throws JsonProcessingException {
        String json = "{\n" +
                "  \"create_time\": \"2020-08-06 08:06:06\"\n" +
                "}";

        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);

        String jsonWithTimestamp = "{\n" +
                "  \"create_time\": \"1596705966000\"\n" +  // 时间戳格式
                "}";

        Person personWithTimestamp = objectMapper.readValue(jsonWithTimestamp, Person.class);
        System.out.println(personWithTimestamp);
    }
}
