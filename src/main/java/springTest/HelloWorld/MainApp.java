package springTest.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by koreyoshi on 2017/11/1.
 */
public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("helloWorld.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();


    }


}
