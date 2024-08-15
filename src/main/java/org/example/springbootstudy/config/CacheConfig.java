package org.example.springbootstudy.config;

import org.example.springbootstudy.myinterface.CacheNames;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(Jackson2JsonRedisSerializer<Object> jsonRedisSerializer) {
        return (builder) -> builder
                //配置多个缓存
                .withCacheConfiguration(CacheNames.CACHE_5MINS, RedisCacheConfiguration
                        .defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                        // 5min过期
                        .entryTtl(Duration.ofMinutes(5L))
                )
                .withCacheConfiguration(CacheNames.CACHE_60MINS, RedisCacheConfiguration
                        .defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                        .entryTtl(Duration.ofHours(1L))
                );
    }

}