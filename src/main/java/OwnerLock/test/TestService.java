package OwnerLock.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/11/6.
 */
public class TestService {
    public static final Map<String,Object> cacheLocks = new HashMap<String,Object>(4);

    public static class TestLock{
        private final Object InnerLock = new Object();
        private volatile boolean isRunning = false;

        private  boolean tryRun(){
            //正在运行
            if(isRunning){
                return false;
            }
            synchronized (InnerLock){
                if(isRunning){
                    return false;
                }
                //没有正在运行任务
                isRunning = true;
                return true;
            }
        }

        public void runComplete(){
            synchronized (InnerLock){
                if(!isRunning){
                    throw new RuntimeException("runComplete exception, running flag is false");
                }
                isRunning = false;
            }

        }


    }
}
