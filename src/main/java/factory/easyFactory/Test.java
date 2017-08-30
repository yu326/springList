package factory.easyFactory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class Test {
    //测试类
    public static void main(String[] args) {
        String loginType = "sms";
        String name = "name";
        String password = "password";
        Login login = LoginManager.verify(loginType);
        boolean bool = login.verify(name,password);
        if(bool){
            //.....  业务逻辑
        }else{
            //.....  业务逻辑
        }


    }
}
