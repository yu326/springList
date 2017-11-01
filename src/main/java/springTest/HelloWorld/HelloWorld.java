package springTest.HelloWorld;

/**
 * Created by koreyoshi on 2017/11/1.
 */
public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

}
