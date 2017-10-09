package test.HashSetTest;

import java.util.*;

/**
 * Created by koreyoshi on 2017/10/9.
 */
public class SetTest {

    public static void main(String[] args) {

        //基于散列表的集合(无序)   HashSet

//        Set<String> words = new HashSet<String>();
//        long totalTime = 0;
//        String s = "yu";
//        String s1 = "yi";
//        words.add(s);
//        words.add(s1);
//
//        Iterator<String> iterable = words.iterator();
//
//        while(iterable.hasNext()){
//            System.out.println(iterable.next());
//        }

        //TreeSet    树集是一个有序集合
        SortedSet<String> sorter = new TreeSet();
        sorter.add("Bob");
        sorter.add("Alice");
        sorter.add("Cral");

        for(String ss :sorter){
            System.out.println(ss);
        }


        //

    }
}
