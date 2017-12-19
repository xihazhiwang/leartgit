package tx.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class Caculate {

    @AnnoTest(value = "相加之和为：")
    public static int add(int a, int b) {
        return a + b;
    }


}
