package factory.staticImplete;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class Demo{
    public static void display(){
        System.out.println("hello");
    }
}

class DemoTest extends Demo{
    public static void display(){
        System.out.println("nihao");
    }
}

