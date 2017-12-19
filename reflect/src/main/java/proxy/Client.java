package proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        /*// 创建被带离的接口实现类的对象
        HireHouseImpl hhi = new HireHouseImpl();
        // 创建代理对象 第一个参数被代理对象的类加载器，第二个参数获得被代理对象的类的所有接口， 第三个参数是自定义代理类的对象
        HireHouse hh = (HireHouse) Proxy.newProxyInstance(hhi.getClass().getClassLoader(), hhi.getClass().getInterfaces(), new HireProxy(hhi));
        hh.hire();*/

        // 创建被带离的接口实现类的对象
        List list = new ArrayList();
        // 创建代理对象 第一个参数被代理对象的类加载器，第二个参数获得被代理对象的类的所有接口， 第三个参数是自定义代理类的对象
        List hh = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new HireProxy(list));
        hh.add("张三");
    }
}
