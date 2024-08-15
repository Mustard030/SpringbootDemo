package org.example.springbootstudy.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;

import java.util.Map;

/**
 * 用于解决异步任务中MDC上下文丢失的问题
 */

@Slf4j
public class MdcTaskDecorator implements TaskDecorator {

    @Override
    @NonNull
    public Runnable decorate(@NonNull Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();//从主线程中取到所有MDC上下文
        return ()->{
            try{
                MDC.setContextMap(contextMap);  //从主线程中获得的Map设置到子线程中
                runnable.run();
            }catch (Exception e){
                log.error(String.valueOf(e));
            }finally {
                MDC.clear();
            }
        };
    }
}