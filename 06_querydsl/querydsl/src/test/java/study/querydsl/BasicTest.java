package study.querydsl;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class BasicTest {

    @Test
    public void test() {
        boolean result = StringUtils.equalsAnyIgnoreCase("aaa", "Aaa");
        System.out.println("result = " + result);

        String a = StringUtils.chop("a");
        System.out.println("a = " + a);
    }
}
