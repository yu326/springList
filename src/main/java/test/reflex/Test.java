package test.reflex;

import java.lang.reflect.Field;

/**
 * Created by koreyoshi on 2017/11/23.
 */
public class Test {
    @org.junit.Test
    public void testGetClass() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        反射机制获取类有三种方法   start

        //        Class clazz = null;

        //1.直接通过类名获取
//        clazz = Person.class;
//        System.out.println("get class by className :" + clazz);

        //2.通过对象的getClass()方法获取
//        TestQuote person = new Person();
//        clazz = person.getClass();
//        System.out.println("get class by getClass :" + clazz);

        //3.通过全类名获取
//        clazz = Class.forName("test.reflex.Person");
//        System.out.println("get class by the whole address :" + clazz);

//     反射机制获取类   end

//        创建对象：获取类以后我们来创建它的对象，利用newInstance：     start

        //实例化类
//        Class c = Class.forName("test.reflex.Person");
//        TestQuote o = null;
//        //创建此Class 对象所表示的类的一个新实例
//        try {
//            o = c.newInstance(); //调用了Employee的无参数构造方法.
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        创建对象：获取类以后我们来创建它的对象，利用newInstance：  end


//        获取属性：分为所有的属性和指定的属性：
//
//        a，先看获取所有的属性的写法：
        //获取整个类
//        Class c = Class.forName("test.reflex.Person");
//        //获取所有的属性?
//        Field[] fs = c.getDeclaredFields();
//
//        //定义可变长的字符串，用来存储属性
//        StringBuffer sb = new StringBuffer();
//        //通过追加的方法，将每个属性拼接到此字符串中
//        //最外边的public定义
//        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
//        //里边的每一个属性
//        for(Field field:fs){
//            sb.append("\t");//空格
//            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
//            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
//            sb.append(field.getName()+";\n");//属性的名字+回车
//        }
//
//        sb.append("}");
//
//        System.out.println(sb);

        //获取类
        Class c = Class.forName("test.reflex.User");
        //获取id属性
        Field idF = c.getDeclaredField("id");
        //实例化这个类赋给o
        Object o = c.newInstance();
        //打破封装
        idF.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。
        //给o对象的id属性赋值"110"
        idF.set(o, 110); //set
        //get
        System.out.println(idF.get(o));



    }
}
