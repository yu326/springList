package fastjson;

/**
 * Created by koreyoshi on 2017/9/5.
 */

import com.alibaba.fastjson.JSON;

/**
 * fastjson测试场景类
 * @author yu
 *
 */
public class Client {
    public static void main(String[] args){
        String str;
        A a = null;
        A a2 = new A();

        //  B b = null;
        //  B b2 = new B();

        a2.setAge(11);
        a2.setName("zs");
        str = JSON.toJSONString(a2);

        System.out.println(str);
        a = JSON.parseObject(str, A.class);

        a.showInfo();
    }
}
