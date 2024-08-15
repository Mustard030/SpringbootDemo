package org.example.springbootstudy.utils;

import cn.hutool.core.util.StrUtil;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * 实现TraceId服务跟踪
 */

public class TraceIdUtils {
    public static String TRACE_ID_KEY = "TraceId";

    /**
     * 生成TraceId
     * @return
     * */
    public static String generateTraceId() {
        String traceId = UUID.randomUUID().toString().toUpperCase();
        MDC.put(TRACE_ID_KEY, traceId);
        return traceId;
    }

    public static String generateTraceId(String traceId) {
        if (StrUtil.isBlank(traceId)){
            return generateTraceId();
        }
        MDC.put(TRACE_ID_KEY, traceId);
        return traceId;
    }

    /**
     * 获取TraceId
     */    public static String getTraceId() {
        return MDC.get(TRACE_ID_KEY);
    }

    /**
     * 移除TraceId
     */    public static void removeTraceId() {
        MDC.remove(TRACE_ID_KEY);
    }
}
