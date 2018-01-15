package test.Entity;

import java.util.Date;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/11/21.
 */
public class Test {
    @org.junit.Test
    public void test() {
        Map<String, Object> useInfos = new java.util.HashMap<String, Object>();
        useInfos.put("id", 1);
        useInfos.put("name", "yu");
        useInfos.put("age", 25);
        useInfos.put("date",new Date());
        HeheEntity userInfoEntity = new HeheEntity(useInfos);
        HelloEntity helloEntity =   new HelloEntity(userInfoEntity);
        System.out.println(helloEntity.toString());
        System.out.println("userName :[ " + userInfoEntity.getName() + " ],age:[ " + userInfoEntity.getAge() + " ].");

    }
}
