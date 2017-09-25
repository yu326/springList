package test.TestHashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by koreyoshi on 2017/9/15.
 */
public class Test {

    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<String, Double>();

        map.put("语文", 80.0);
        map.put("数学", 89.0);
        map.put("英语", 78.2);
        System.out.println(map);


        HashSet<Object> set = new HashSet<Object>();
        set.add("123");
        System.out.println(set);

    }
}
