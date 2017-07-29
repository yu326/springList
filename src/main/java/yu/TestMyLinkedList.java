package yu;

import java.util.Iterator;

/**
 * Created by korey on 2017/7/29.
 */
public class TestMyLinkedList {
    public static void main(String[] args)
    {
//        MyLinkedList<String> list=new MyLinkedList<String>();
//        list.add("dslfjsld");
//        list.add("3947fo");
//        list.add("flds34");
//        list.add("0");
//        list.add("xYz");
//        list.add("A");
//        list.add("a");
//        list.add("bdc");
//        list.add("B39vdslfjl");
//
//
//        for(Iterator iter = list.iterator(); iter.hasNext();)
//            //注意是迭代器的而不是集合的next()方法！！
//            System.out.println(iter.next());
//        System.out.println("----------------Hello World!--------------------");
//        //实现Iterable就可以用高级for循环
//        //每次都会new一个新的Iterator对象指向第一个元素
//        //要用泛型
//        for(String str:list)
//            System.out.println(str);

        MytestLink link = new MytestLink();
        System.out.println(link.isEmpty());
        System.out.println(link);
        link.add("1111");
        System.out.println(link.isEmpty());
        link.add("2222");
        link.add("33333");
        link.add("44444");
        link.set(0,"1");
        System.out.println(link.get(1));
        link.set(1,"2");
        System.out.println(link.get(1));
        link.remove(1);
        System.out.println(link.get(1));
        System.out.println("--------------------------");
        for(Iterator iter = link.iterator(); iter.hasNext();)
//            //注意是迭代器的而不是集合的next()方法！！
            System.out.println(iter.next());

    }
}
