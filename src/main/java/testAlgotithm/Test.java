package testAlgotithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koreyoshi on 2017/8/11.
 */
public class Test {
    private final static int DEFAULT_PEOPLE = 4;

    /**
     * xx 数列
     * 从第一个报数，没到3，这个人必须自杀，下一个从1开始。
     * 如果我们要n个人活下来，那么这n个人应该站在哪才能活下来呢。
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        for (int i = 1; i < 42; i++) {
            a.add(i);
        }
        System.out.println("总人数：[" + a.size() + "]。他们的编号分别是：" + a);
        Iterator<Integer> i = a.iterator();
        int num = 0;
        List res = handleList(a, num);
        System.out.println("要活下来的人数：[" + DEFAULT_PEOPLE + "]。 他们的编号是 ：" + res);
    }

    public static List handleList(List list, int num) {
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            num++;
            Integer str = (Integer) i.next();
            if (num == 3) {
                i.remove();
                num = 0;
            }
            if (list.size() == DEFAULT_PEOPLE) {
                return list;
            }
        }
        list = handleList(list, num);
        return list;
    }
}
