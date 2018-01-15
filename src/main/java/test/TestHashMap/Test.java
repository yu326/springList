package test.TestHashMap;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by koreyoshi on 2017/9/15.
 */
public class Test {

    public static void main(String[] args) {
//        HashMap<String, Double> map = new HashMap<String, Double>();
//
//        map.put("语文", 80.0);
//        map.put("数学", 89.0);
//        map.put("英语", 78.2);
//        System.out.println(map);
//
//
//        HashSet<TestQuote> set = new HashSet<TestQuote>();
//        set.add("123");
//        System.out.println(set);

        JSONObject data = new JSONObject(3);
        data.put("suixin","yu");
        data.put("suiyuan","yi");
        data.put("yu","love");


        for (Map.Entry<String, Object> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        Map<String,Object> map = new HashMap<String, Object>();
        map.put("suixin","yu");
        map.put("suiyuan","yi");
        map.put("yu","love");
        for (Map.Entry<String,Object> entry : map.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());
        List<Object> list = new ArrayList<Object>(3);
        list.add("yu");
        list.add("yu1");
        list.add("yu2");


        Iterator it = list.iterator();
        while(it.hasNext()) {
                 Object obj = it.next();
                 System.out.println(obj);
        }


    }
}
