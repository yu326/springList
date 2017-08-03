package yu.test;

import java.util.HashMap;

/**
 * Created by koreyoshi on 2017/8/3.
 */
//@Configuration
public class Outer {
    private Inner inner = null;

    public Outer(){
        inner = Inner.getconfig();
    }

    public String getSolrNameBy(final String cacheName) {
        return inner.testDatasMap.get(cacheName);
    }

    public static class Inner{
        private static Inner instance = null;

        //测试
        private HashMap<String,String> testDatasMap = new HashMap<String, String>(4);



        public static Inner getconfig(){
            if(instance !=null){
                return instance;
            }
            synchronized(Inner.class){
                if(instance!=null){
                    return instance;
                }

                //初始化该配置类
                Inner tmp = null;
                try{
                    tmp = new Inner();
                    tmp.addValue();

                }catch (Exception e){
                    e.printStackTrace();
                }
                instance = tmp;
                return instance;
            }

        }

        public void addValue(){
            this.testDatasMap.put("test","suixin");
        }
    }
}
