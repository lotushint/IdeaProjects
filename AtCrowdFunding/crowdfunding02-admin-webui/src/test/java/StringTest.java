import com.lotushint.crowd.util.CrowdUtil;
import org.junit.Test;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/16 9:59
 * @package PACKAGE_NAME
 * @description
 */
public class StringTest {
    /**
     * 测试 md5明文加密
     */
    @Test
    public void testMd5() {
        String source = "123123";
        String encoded = CrowdUtil.md5(source);
        System.out.println(encoded);
    }

    @Test
    public void testSync() {
        method01();
    }

    public void method01() {
        System.out.println("1111111111开始");
        method02();
        System.out.println("1111111111结束");
    }

    public void method02() {
        System.out.println("2222222222开始");
        method03();
        System.out.println("2222222222结束");
    }

    public void method03() {
        System.out.println("3333");
    }
}
