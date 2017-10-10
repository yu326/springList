package test.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by korey on 2017/10/8.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<String>();
        a.add("Amy");
        a.add("Cral");
        a.add("Erica");

        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doidb");
        b.add("France");
        b.add("Grollia");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a.size());

        //remove every second word from  b
//        bIter = b.iterator();
//        while (bIter.hasNext()) {
//            bIter.next();
//            if (bIter.hasNext()) {
//                bIter.next();
//                bIter.remove();
//            }
//        }
//
//        bIter = b.iterator();
//        while (bIter.hasNext()) {
//            System.out.println(bIter.next());
//        }

        //remove all words in b from a
        a.removeAll(b);
        System.out.println(a.size());

    }
}
