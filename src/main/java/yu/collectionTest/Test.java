package yu.collectionTest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by koreyoshi on 2018/1/22.
 */
public class Test {
    public static void main(String[] args) {
        //链表数组 -- 可以高效删除和添加的数组
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.remove(0);

        //hashSet -- 没有重复数据的无序集合
        HashSet<String> hashSet = new HashSet();
        hashSet.add("10");
        hashSet.add("2");
        hashSet.add("z");
        hashSet.add("a");
        hashSet.remove("3");
        System.out.println(hashSet.toString());
        //treeSet  -- 一种有序集
        TreeSet<String> treeSet = new TreeSet();
        treeSet.add("10");
        treeSet.add("2");
        treeSet.add("z");
        treeSet.add("a");
        treeSet.remove("3");
        System.out.println(treeSet.toString());
        //linkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("10");
        linkedHashSet.add("2");
        linkedHashSet.add("z");
        linkedHashSet.add("a");
        linkedHashSet.remove("3");
        System.out.println(linkedHashSet.toString());
    }
}
