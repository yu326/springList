package test.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by korey on 2017/10/8.
 */
public class Test {
    /**
     * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * offer       添加一个元素并返回true       如果队列已满，则返回false
     * poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * peek       返回队列头部的元素             如果队列为空，则返回null
     * put         添加一个元素                      如果队列满，则阻塞
     * take        移除并返回队列头部的元素     如果队列为空，则阻塞
     */
    public static void main(String[] args) {

        //   用链表实现的queue

//        Queue<String> queue = new LinkedList<String>();
//        queue.offer("a");
//        queue.offer("b");
//        queue.offer("c");
//        queue.offer("d");
//        queue.offer("e");
//
//        Object resValue = queue.poll();
//        System.out.println("the resValue is:" + resValue);
//
//
//        Iterator<String> iterable = queue.iterator();
//
//        while (iterable.hasNext()) {
//            Object value = iterable.next();
//            System.out.println("the value is:" + value);
//        }
        //    用循环数组实现的queue

//        Queue<String> q = new ArrayBlockingQueue(5);
//        q.add("a");
//        q.add("b");
//        q.add("c");
//        q.add("d");
//        q.add("e");
//        boolean res = q.add("f");
//        System.out.println("the res is:" + res);
//        Iterator<String> iterable = q.iterator();
//
//        while (iterable.hasNext()) {
//            Object value = iterable.next();
//            System.out.println("the value is:" + value);
//        }


        //  几个集合的常用方法的测试
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //containsAll  判断集合中是否包含list集合中的所有元素，是则返回true。否则 false。
//        boolean res = list1.containsAll(list);
//        System.out.println("the containsAll res is:" + res);
        //addAll  将list集合中的全部元素添加到这个集合中。如果这个调用改变了集合，返回true。
//        boolean addAllRes = list1.addAll(list);
//        System.out.println("the addAll res is:" + addAllRes);
//
//        Iterator<String> iterable = list.iterator();
//        while (iterable.hasNext()){
//            System.out.println(iterable.next());
//        }


//        list1.add("a");
        // removeAll   从这个集合中删除list集合中存在的所有元素，如果由于这个调用改变了集合，返回true。
//        boolean removeAllRes = list1.removeAll(list);
//        System.out.println("the removeAll res is:" + removeAllRes);
//        System.out.println("the list1 size is:" + list1.size());

        // 从这个集合中删除所有元素
//        list.clear();
//        System.out.println("after clear list size is:" + list.size());

//        list1.add("a");
//        list1.add("z");
//        list1.add("w");
        //  retainAll 从集合中删除所有list集合中存在的所有的元素，如果这个调用改变了集合，返回true。
//        boolean retainAllRes = list1.retainAll(list);
//        System.out.println("the retainAll res is:" + retainAllRes);
//        Iterator<String> iterable = list1.iterator();
//        while (iterable.hasNext()){
//            System.out.println(iterable.next());
//        }

        // Iterator 必须先调用hasNext 方法，判断是否有下一个元素。调用remove方法，必须先调用next方法，否则跑出一个异常
//        Iterator<String> iterable = list.iterator();
//        while (iterable.hasNext()){
//            System.out.println(iterable.next());
//            iterable.remove();
//        }
//        System.out.println(list.size());

        // toArray  返回这个集合的对象数组

        Object[] o = list.toArray();
        System.out.println(o.length);
        for (int i=0;i<o.length;i++) {
            System.out.println(o[i]);
        }



    }
}
