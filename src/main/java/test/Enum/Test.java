package test.Enum;

import static test.Enum.constant.MAX_NUM;
import static test.Enum.constant.MIN_NUM;

/**
 * Created by koreyoshi on 2017/10/9.
 */
enum constant {
    MAX_NUM, MIN_NUM

}

public class Test {
    public static void main(String[] args) {
        MAX_NUM.name();
        System.out.println(MAX_NUM);
        System.out.println(MIN_NUM);
    }

}


