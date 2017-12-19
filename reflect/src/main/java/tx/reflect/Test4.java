package tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test4 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("cn.tx.reflect.Person");

        // 构造器
        Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{});
        System.out.println(constructor);

        // 根据类的默认构造器获取一个对象
        Object instance = constructor.newInstance(new Object[]{});
        System.out.println(instance);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // 获取方法的名字
            String name = m.getName();
            boolean startsWith = name.startsWith("set");
            if (startsWith) {
                // 获取到了set字符串后面的值
                String fieldName = name.substring(3);
                fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
                Field field = clazz.getDeclaredField(fieldName);
                // 获取属性的具体类型
                Class<?> type = field.getType();
                if (type == Integer.class) {
                    m.invoke(instance, new Object[]{1});
                }
                if (type == String.class && "adress".equals(fieldName)) {
                    m.invoke(instance, "北京");
                }
                if (type == String.class && "name".equals(fieldName)) {
                    m.invoke(instance, "张飞");
                }
            }
        }
        System.out.println(instance);

        /*Constructor<?> constructor1 = clazz.getDeclaredConstructor(new Class[]{
                Integer.class, String.class, String.class});
        Object instance1 = constructor1.newInstance(1, "李四", "北京");
        System.out.println(instance1);*/

    }



}






























































