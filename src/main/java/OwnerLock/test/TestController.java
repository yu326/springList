package OwnerLock.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/11/6.
 */
public class TestController {
    public static final Map<String, ImportLock> cacheLocks = new HashMap<String, ImportLock>(4);





    public static class ImportLock {
        private final Object InnerLock = new Object();
        private volatile boolean isRunning = false;

        public boolean isIsRunning() {
            return isRunning;
        }

        public boolean tryRun() {
            //正在运行
            if (isRunning) {
                return false;
            }

            synchronized (InnerLock) {
                if (isRunning) {
                    return false;
                }

                // 没有在运行入库任务
                isRunning = true;
                return true;
            }
        }

        public void runComplete() {
            synchronized (InnerLock) {
                if (!isRunning) {
                    throw new RuntimeException("runComplete exception, running flag is false");
                }
                isRunning = false;
            }
        }
    }
}
