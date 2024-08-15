package org.example.springbootstudy.serializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MyLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String text = p.getText();
        try {
            if (text.matches("^\\d+$")) {
                // 时间戳转LocalDateTime
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(text)), ZoneId.systemDefault());
            } else {
                // 字符串转LocalDateTime
                return LocalDateTime.parse(text, FORMATTER);
            }
        } catch (Exception e) {
            throw new JsonParseException("Could not parse timestamp '" + text + "'");
        }
    }
}