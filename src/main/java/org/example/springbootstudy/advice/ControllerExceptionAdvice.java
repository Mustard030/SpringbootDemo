package org.example.springbootstudy.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.pojo.R;
import org.example.springbootstudy.utils.ResponseConstantEnum;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {
    //自行添加需要拦截的错误类型和R类信息
    @ExceptionHandler(BindException.class)
    public R<?> MethodArgumentNotValidException(BindException e) {
        ObjectError error = e.getBindingResult().getAllErrors().getFirst();
        return R.error(ResponseConstantEnum.VALIDATE_ERROR, error.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<?> Exception(Exception e) {
        log.error("未知异常！", e);
        return R.error(ResponseConstantEnum.ERROR);
    }
}
