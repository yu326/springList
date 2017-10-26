package test.synchr;

/**
 * Created by koreyoshi on 2017/10/26.
 */
public class Sync {
    public  void test() {

        synchronized(Sync.class){
            try {
                System.out.println("test开始..");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }

    }
}

class MyThread extends Thread {

    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

 class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
