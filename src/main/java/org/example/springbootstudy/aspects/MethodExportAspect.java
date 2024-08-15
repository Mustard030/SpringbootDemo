package org.example.springbootstudy.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect //关键1：说明当前类是一个切面类
@Component  //关键2：允许在Spring ioc对当前对象实例化并管理
@Slf4j
public class MethodExportAspect {
    //关键3：说明切面的作用范围，任何增加@MethodExporter的目标方法都将在执行方法前先执行该切面方法
    //@Around环绕通知，最强大的通知类型，可以控制方法入参，执行，返回结果等各方面细节
    @Around("@annotation(org.example.springbootstudy.myinterface.MethodExporter)")  //如果某个方法上出现了这个注解，就执行下面的代码
    public Object methodExporter(ProceedingJoinPoint joinPoint) throws Throwable {
        long st = new Date().getTime();

        //执行目标方法，获取方法返回值
        Object proceed = joinPoint.proceed();

        long et = new Date().getTime();

        ObjectMapper mapper = new ObjectMapper();
        //将入参Json序列化
        String jsonParam = mapper.writeValueAsString(joinPoint.getArgs());
        //将返回结果Json序列化
        String jsonResult = null;
        if (proceed != null) {
            jsonResult = mapper.writeValueAsString(proceed);
        } else {
            jsonResult = "null";
        }

        //模拟上报过程
        log.debug("正在上报服务器调用过程:\ntarget:{}.{}()\nexecution:{}ms,\nparameter:{}\nresult:{}",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                (et-st),
                jsonParam,
                jsonResult
        );
        return proceed;
    }
}
