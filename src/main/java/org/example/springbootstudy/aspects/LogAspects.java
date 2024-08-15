package org.example.springbootstudy.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {
    @Pointcut("execution(* org.example.springbootstudy.utils.AnyFunction.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("around..Before..");
        Object o = null;
        try {
            o = joinPoint.proceed();
            System.out.println("around..After..");
        } catch (Throwable e) {
            System.out.println(e);
        }
        return o;
    }
}
