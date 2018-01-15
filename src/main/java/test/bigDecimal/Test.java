package test.bigDecimal;

import java.math.BigDecimal;

/**
 * Created by koreyoshi on 2017/12/5.
 */
public class Test {
    @org.junit.Test
    public void test(){
        double f = (double) 0.1;
        String s = String.valueOf(f);

        BigDecimal d = new BigDecimal(f);
        BigDecimal d2 = BigDecimal.valueOf(f);
        BigDecimal d1 = new BigDecimal(s);


        System.out.println(d);
        System.out.println(d.toString().length());
        System.out.println(d2);
        System.out.println(d1);

    }
}
