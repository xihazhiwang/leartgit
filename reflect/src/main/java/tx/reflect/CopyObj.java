package tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyObj {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        p.setAdress("长春");
        p.setName("李四");
        p.setId(1);
        Object object = CopyObject(p);
        System.out.println(object);
    }

    public static Object CopyObject(Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取传递过来的对象的属性和构造器
        Class<?> class1 = obj.getClass();
        Field[] fields = class1.getDeclaredFields();
        Constructor<?> constructor = class1.getConstructor(new Class[]{});
        // 创建一个对象
        Object instance = constructor.newInstance(new Object[]{});
        for (Field f : fields) {
            // 获取属性的name
            String name  = f.getName();
            // 获取属性的类型
            Class<?> type = f.getType();
            // 获取属性对应的set方法
            String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            String getMethodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获得get方法
            Method gmethod = class1.getMethod(getMethodName, null);
            // 调用get方法获得被拷贝的一个属性值
            Object gresult = gmethod.invoke(obj, null);
            Method smethod = class1.getDeclaredMethod(setMethodName, new Class[]{type});
            smethod.invoke(instance, new Object[]{gresult});
        }
        return instance;
    }
}
