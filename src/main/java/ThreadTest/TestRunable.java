package ThreadTest;

/**
 * Created by korey on 2017/11/5.
 */
public class TestRunable implements Runnable {
    public void run(){
        try {
            String name = Thread.currentThread().getName();
            String inf=Thread.currentThread().toString();
            long idnum = Thread.currentThread().getId();
            System.out.println(Thread.currentThread().getPriority());

            System.out.println("thread name=="+ name
                        +",threadid=="+ idnum+",thread inf=="+inf);

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
