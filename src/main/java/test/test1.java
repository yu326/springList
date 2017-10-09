package test;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class test1 extends Base{

    static{
        System.out.println("test static");
    }

    public test1(){
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new test1();
    }
}

class Base{

    static{
        System.out.println("base static");
    }

    public Base(){
        System.out.println("base constructor");
    }
}
