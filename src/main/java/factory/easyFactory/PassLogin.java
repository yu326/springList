package factory.easyFactory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class PassLogin implements Login {

    public boolean verify(String name, String pass) {

        //略过逻辑处理

        return true;
    }
}
