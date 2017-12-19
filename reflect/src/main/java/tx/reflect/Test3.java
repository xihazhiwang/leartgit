package tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> clazz = Class.forName("cn.tx.reflect.Person");

        Field field = clazz.getDeclaredField("adress");
        System.out.println(field);

        Method method = clazz.getMethod("getName", new Class[]{});
        System.out.println(method);

        Method method1 = clazz.getMethod("setName", new Class[]{String.class});
        System.out.println(method1);

        Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{});
        System.out.println(constructor);

        Constructor<?> constructor1 = clazz.getDeclaredConstructor(new Class[]{Integer.class, String.class, String.class});
        System.out.println(constructor1);

    }



}






























































