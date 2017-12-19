package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HireProxy implements InvocationHandler {

    // 被代理的真是角色
    private Object obj;

    public HireProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * jdk的动态代理，被带离的对象必须实现接口
     * @param proxy
     * @param method    被代理对象的接口方法
     * @param args      被代理对象的接口方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置工作");
        System.out.println("---------参数----------");
        for (Object obj : args) {
            System.out.println(obj);
        }
        System.out.println("---------参数----------");
        Object invoke = method.invoke(obj, args);
        System.out.println("后置工作");
        return invoke;
    }
}
