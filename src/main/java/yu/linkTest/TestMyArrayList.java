package yu.linkTest;

import java.util.Iterator;

/**
 * Created by korey on 2017/7/30.
 */
public class TestMyArrayList {
    public static void main(String[] args) {

//        ArrayList a = new ArrayList();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.remove(1);
//        System.out.println(a);



        MyTestArrayList mal = new MyTestArrayList();

        mal.add(1);
        mal.add("2");
        mal.add(3);
        mal.add("4");
        mal.add("5");
        mal.add("6");
        mal.add("7");
        mal.add("8");
        mal.add("9");
        mal.add("10");
        mal.add("11");
        mal.add("12");
        mal.remove(3);
        System.out.println(mal);
//        System.out.println(mal.remove(3));
//        System.out.println(mal);

//        for(java.util.Iterator<String> its=mal.iterator();its.hasNext();){
//            System.out.println(its.next());
//            its.remove();
//            //这里要看到元素，得自己实现toString方法然后调用！
//            System.out.println(mal);
//        }
        for (Iterator its = mal.iterator(); its.hasNext(); ) {
            System.out.println(its.next());
            its.remove();

        }


//        for (java.util.Iterator<String> its =mal.iterator();its.hasNext();){
//            String tmp = its.next();
//            System.out.println(tmp);
//            if(tmp == "3"){
//                its.remove();
//            }
//
//        }

    }
}
