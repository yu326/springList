package test.TestVolatile;

/**
 * Created by koreyoshi on 2017/11/7.
 */
public class TestYu implements Runnable {


    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestYu test = new TestYu();
        try {
            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(test);
                t.start();
            }

            while (Thread.activeCount() > 1)  //保证前面的线程都执行完
                Thread.yield();
            System.out.println(test.inc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }

    public void run() {
        for (int j = 0; j < 10; j++)
            increase();
    }


}
