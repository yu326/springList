package ThreadTest;

/**
 * Created by korey on 2017/11/5.
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println("beginning");
        TestRunable tr = new TestRunable();
        Thread t = new Thread(tr);
        Thread t1 = new Thread(tr);
        t1.setPriority(6);
        System.out.println("t1 status is:"+t.getState());
        System.out.println("before t start");
        t.start();

        System.out.println("t1 status is:"+t1.getState());
        System.out.println("before t1 start");
        t1.start();
    }
}
