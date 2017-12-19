package tx.test;

import tx.anno.AnnoTest;
import tx.anno.Caculate;
import tx.enum1.HttpMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {

//    @AnnoTest(value = "asdfasdf", location = "asdfasd", method = HttpMethod.GET)
    @org.junit.Test
    public void tset() {

    }

    @org.junit.Test
    public void testEnum() {
        System.out.println(HttpMethod.GET);
        for (HttpMethod httpMethod : HttpMethod.values()) {
            System.out.println(httpMethod.getClass());
        }

    }

    @org.junit.Test
    public void testAdd() {
        Class c = Caculate.class;
        try {
            Object o = c.newInstance();
            Method add = c.getMethod("add", new Class[]{int.class, int.class});
            Object result = add.invoke(o, new Object[]{2, 5});
            AnnoTest annotation = add.getAnnotation(AnnoTest.class);
            System.out.println(annotation.value() + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
