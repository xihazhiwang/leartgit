package tx.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我们创建出来的注解自动的实现了Annotation接口
 * 非标识注解（注解内有值），通过反射方式调用这个方法的时候才有意义
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnoTest {

    /**
     * 注解内部可以定义值，这里面的值既不是属性也不是方法
     * 语法：数据类型 值得名字();
     */
    String value();

}
