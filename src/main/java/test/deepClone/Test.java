package test.deepClone;

/**
 * Created by koreyoshi on 2017/9/5.
 */
public class Test {



    public static void main(String[] args) throws CloneNotSupportedException {

        //对象引用的复制

//        Person p = new Person(23, "zhang");
//        Person p1 = p;
//
//        System.out.println(p);
//        System.out.println(p1);


        //对象的拷贝
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();

        System.out.println(p);
        System.out.println(p1);


//        Person p = new Person(23, "zhang");
//        Person p1 = (Person) p.clone();
//
//        String result = p.getName() == p1.getName()
//                ? "clone是浅拷贝的" : "clone是深拷贝的";
//
//        System.out.println(result);
        //验证深拷贝，浅拷贝





    }

}
