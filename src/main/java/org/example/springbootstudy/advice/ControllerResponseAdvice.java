package org.example.springbootstudy.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.example.springbootstudy.myinterface.NotRestController;
import org.example.springbootstudy.pojo.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"org.example.springbootstudy"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //如果是R类型或者注释了@NotRestController都不进行包装
        return !(returnType.getParameterType().isAssignableFrom(R.class)
                || returnType.hasMethodAnnotation(NotRestController.class));
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //String类型不能直接包装
        if (body instanceof String){
            try {
                //将数据包装在R里后转换为json串返回
                return objectMapper.writeValueAsString(R.ok(body));
            } catch (JsonProcessingException e){
                e.printStackTrace();
            }
        }
        //否则直接包装成R返回
        return R.ok(body);
    }
}
