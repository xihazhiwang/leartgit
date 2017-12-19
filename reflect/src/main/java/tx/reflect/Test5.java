package tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test5 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("cn.tx.reflect.Person");

        // 构造器
        Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{});
        System.out.println(constructor);

        // 根据类的默认构造器获取一个对象
        Object instance = constructor.newInstance(new Object[]{});
        // 根据方法名字来获取属性对象
        Field field = clazz.getDeclaredField("name");
        // 破坏掉私有属性
        field.setAccessible(true);
        field.set(instance, "张三");

        // 获得属性的类型
        Class<?> type = field.getType();
        System.out.println(type);
    }



}






























































