package factory.easyFactory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class LoginManager {
    public static Login verify(String type) {
        if (type.equals("password")) {
            return new PassLogin();
        } else if (type.equals("sms")) {
            return new SmsLogin();
        } else {
            throw new RuntimeException("非法登录类型");
        }
    }
}
