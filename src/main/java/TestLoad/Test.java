package TestLoad;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class Test {
    public static void main(String[] args) {
        try {

//查看当前系统类路径中包含的路径条目

            System.out.println(System.getProperty("java.class.path"));

//调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean

            Class typeLoaded = Class.forName("TestLoad.bean.TestBean");

//查看被加载的TestBean类型是被那个类加载器加载的

            System.out.println(typeLoaded.getClassLoader());

        } catch (Exception e) {

            e.printStackTrace();

        }

        //查看系统类加载工具，标准扩展类工具，启动类加载器的关系
//        try {
//            System.out.println(ClassLoader.getSystemClassLoader());
//            System.out.println(ClassLoader.getSystemClassLoader().getParent());
//            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
