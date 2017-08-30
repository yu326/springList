package factory.staticImplete;

/**
 * Created by koreyoshi on 2017/8/30.
 */

public class TestStaticExtend{
    public static void main(String args[]){
        Demo d=new Demo();
        d.display();
        d=new DemoTest();//注意观察这条语句的输出，是输出hello还是nihao
        d.display();
    }
}