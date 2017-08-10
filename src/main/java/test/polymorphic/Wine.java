package test.polymorphic;

import java.util.ArrayList;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class Wine {
    public void fun1(){
        System.out.println("Wine 的Fun.....");
        fun2();
    }

    public void fun2(){
        ArrayList A = new ArrayList();
        System.out.println("Wine 的Fun2...");
    }
}



