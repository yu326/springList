package yu.linkTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by koreyoshi on 2017/7/31.
 */
public class SinaPushCode {

    private static transient long sinceId = -1L;
    private final int recBufSize = 256;
    private HttpClient httpClient;
    private String receiveCommentUrl;
    private DataInputStream inputStream;
    private byte[] recBuf;
    private int recIndex;

    public static void main(String[] args) {
        SinaPushCode test = new SinaPushCode();
        test.init();
    }

    /**
     * 初始化httpclient，并启动获取数据线程
     */
    public void init() {
        receiveCommentUrl = "https://c.api.weibo.com/commercial/push?subid=10050";
        MultiThreadedHttpConnectionManager httpConnManager = new MultiThreadedHttpConnectionManager();
        httpConnManager.getParams().setMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION, 10);
        httpConnManager.getParams().setMaxTotalConnections(10);
        httpConnManager.getParams().setSoTimeout(10 * 60 * 1000);
        httpConnManager.getParams().setConnectionTimeout(10000);
        httpConnManager.getParams().setReceiveBufferSize(655350);

        httpClient = new HttpClient(httpConnManager);

        new ReadTask().start();
    }

    /**
     * 获取数据线程
     */
    class ReadTask extends Thread {

        /**
         * 启一个线程从服务器读取数据
         */
        @Override
        public void run() {
            boolean hasError = false;
            while (!hasError) {
                GetMethod method = null;
                recIndex = 0;
                recBuf = new byte[recBufSize];
                try {
                    method = connectServer(sinceId);
                    while (true) {
                        processLine();
                    }
                } catch (Exception e) {
                    // 当连接断开时，重新连接
                    System.out.println("connection close: " + e.getMessage());
                    if (e.getMessage().contains("errorCode")) {
                        hasError = true;
                    }
                    System.out.println("last since_id: " + sinceId);
                } finally {
                    if (method != null) {
                        method.releaseConnection();
                    }
                }
            }
        }

        /**
         * 建立http连接
         *
         * @return
         */
        private GetMethod connectServer(long sinceId) throws Exception {
            String targetURL = receiveCommentUrl;
            // 从指定的since_id开始读取数据，保证读取数据的连续性，消息完整性
            if (sinceId > 0L) {
                targetURL = targetURL + "&since_id=" + sinceId;
            }
            System.out.println("get url: " + targetURL);

            GetMethod method = new GetMethod(targetURL);
            int statusCode;
            try {
                statusCode = httpClient.executeMethod(method);
            } catch (Exception e) {
                method.releaseConnection();
                throw new Exception("stream url connect failed", e);
            }

            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException(method.getResponseBodyAsString());
            }

            try {
                inputStream = new DataInputStream(method.getResponseBodyAsStream());
            } catch (IOException e) {
                throw new RuntimeException("get stream input io exception", e);
            }

            return method;
        }

        /**
         * 读取并处理数据
         *
         * @throws IOException
         */
        private void processLine() throws IOException {
            byte[] bytes = readLineBytes();
            if ((bytes != null) && (bytes.length > 0)) {
                String message = new String(bytes);
                handleMessage(message);
            }
        }

        /**
         * 可以重写此方法解析message
         *
         * @param message
         */
        private void handleMessage(String message) {
            System.out.println(message);
            JSONObject jsonObject = JSON.parseObject(message);
            sinceId = jsonObject.getLongValue("id");
        }

        /**
         * 读取数据
         *
         * @return
         * @throws IOException
         */
        public byte[] readLineBytes() throws IOException {
            byte[] result;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int readCount;
            if ((recIndex > 0) && (read(bos))) {
                return bos.toByteArray();
            }
            while ((readCount = inputStream.read(recBuf, recIndex, recBuf.length - recIndex)) > 0) {
                recIndex = (recIndex + readCount);
                if (read(bos)) {
                    break;
                }
            }
            result = bos.toByteArray();
            if (result == null || result.length <= 0 && recIndex <= 0) {
                throw new IOException("no data in 5 second");
            }
            return result;
        }

        /**
         * 读数据到bos
         *
         * @param bos
         * @return
         */
        private boolean read(ByteArrayOutputStream bos) {
            boolean result = false;
            int index = -1;
            for (int i = 0; i < recIndex - 1; i++) {
                // 13cr-回车 10lf-换行
                if ((recBuf[i] == 13) && (recBuf[(i + 1)] == 10)) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                bos.write(recBuf, 0, index);
                byte[] newBuf = new byte[recBufSize];
                if (recIndex > index + 2) {
                    System.arraycopy(recBuf, index + 2, newBuf, 0, recIndex - index - 2);
                }
                recBuf = newBuf;
                recIndex = (recIndex - index - 2);
                result = true;
            } else if (recBuf[(recIndex - 1)] == 13) {
                bos.write(recBuf, 0, recIndex - 1);
                Arrays.fill(recBuf, (byte) 0);
                recBuf[0] = 13;
                recIndex = 1;
            } else {
                bos.write(recBuf, 0, recIndex);
                Arrays.fill(recBuf, (byte) 0);
                recIndex = 0;
            }

            return result;
        }
    }
}
