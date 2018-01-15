package BloomFilter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/10/31.
 */
public class Hash {

    @Test
    public void test() {
        Map<String, Object> m = new HashMap();
        m.put("1", "2");
    }

    @Test
    public void hash0() {
        String key = "123";
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 33 * hash + key.charAt(i);

        System.out.println(hash);

    }

    @Test
    public void hash1() {
        String key = "123";
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 131 * hash + key.charAt(i);

        System.out.println(hash);
    }

    @Test
    public void hash2() {
        String key = "123";
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 1313 * hash + key.charAt(i);

        System.out.println(hash);

    }

    @Test
    public void hash3() {
        String key = "123";
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 13131 * hash + key.charAt(i);

        System.out.println(hash);

    }

    @Test
    public void hash4() {
        String key = "123";
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 131313 * hash + key.charAt(i);

        System.out.println(hash);

    }


}
