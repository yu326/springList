package BloomFilter;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by koreyoshi on 2017/10/30.
 */
public class BloomFilter {

    private static Jedis jedis;

    private static final int BIT_SIZE = 2 << 28;//二进制向量的位数，相当于能存储1000万条url左右，误报率为千万分之一
    private static final int[] seeds = new int[]{3, 5, 7, 11, 13, 31, 37, 61};//用于生成信息指纹的8个随机数，最好选取质数

    private static final String REDIS_CACHE_KEY = "key1";
    //    private BitSet bits = new BitSet(BIT_SIZE);
    private Hash[] func = new Hash[seeds.length];//用于存储8个随机哈希值对象

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new Hash(BIT_SIZE, seeds[i]);
        }

    }

    @org.junit.Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
//        jedis.auth("");
    }

    /**
     * 像过滤器中添加字符串
     */
    public void addValue(String value) {
        //将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
        if (value != null) {
            for (Hash f : func) {
                jedis.setbit(REDIS_CACHE_KEY, f.hash(value), true);
//                bits.set(f.hash(value), true);
            }
        }
    }

    /**
     * 判断字符串是否包含在布隆过滤器中
     */

    public boolean contains(String value) {
        if (value == null)
            return false;

        boolean ret = true;

        //将要比较的字符串重新以上述方法计算hash值，再与布隆过滤器比对
        for (Hash f : func) {
            boolean redisIssetRes = jedis.getbit(REDIS_CACHE_KEY, f.hash(value));
            if (!redisIssetRes) {
                return false;
            }
            ret = ret && redisIssetRes;
        }


        return ret;
    }

    /**
     * 随机哈希值对象
     */

    public static class Hash {
        private int size;//二进制向量数组大小
        private int seed;//随机数种子

        public Hash(int cap, int seed) {
            this.size = cap;
            this.seed = seed;
        }

        /**
         * 计算哈希值(也可以选用别的恰当的哈希函数)
         */
        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (size - 1) & result;
        }

    }

    @Test
    public void test() {
        try {
            jedis = new Jedis("127.0.0.1", 6379);
            String s = "www.baidu.com";
            String s1 = "yu";
            String s2 = "呵呵哒";
            System.out.println(checkInRedis(s));
            System.out.println(checkInRedis(s1));
            System.out.println(checkInRedis(s2));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String checkInRedis(String s) {
        BloomFilter b = new BloomFilter();
        boolean res = false;
        if (b.contains(s)) {
            return "[ " + s + " ] 已经存在redis中";
        } else {
            b.addValue(s);
            return "[ " + s + " ] 不存在，redis已经添加成功~";
        }
    }


}

