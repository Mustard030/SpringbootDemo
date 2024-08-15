package org.example.springbootstudy.entity;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//public class TestProxy implements InvocationHandler {
//    private final Object object;   //这里需要保存一下被代理的对象，下面需要用到
//
//    public TestProxy(Object object) {
//        this.object = object;
//    }
//
//    @Override   //此方法就是调用代理对象的对应方法时会进入，这里我们就需要编写如何进行代理了
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //method就是调用的代理对象的哪一个方法，args是实参数组
//        System.out.println("代理的对象："+proxy.getClass());   //proxy就是生成的代理对象了，我们看看是什么类型的
//        Object res = method.invoke(object, args);   //在代理中调用被代理对象原本的方法，因为你是代理，还是得执行一下别人的业务，当然也可以不执行，但是这样就失去代理的意义了，注意要用上面的object
//        System.out.println("方法调用完成，返回值为："+res);   //看看返回值是什么
//        return res;   //返回返回值
//    }
//}
public class TestProxy implements MethodInterceptor {//首先还是编写代理逻辑
    private final Object target;   //这里需要保存一下被代理的对象，下面需要用到

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override   //此方法就是调用代理对象的对应方法时会进入，这里就需要编写如何进行代理了
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("由cglib进行代理"+ o.getClass());
        return method.invoke(target, args);
    }
}