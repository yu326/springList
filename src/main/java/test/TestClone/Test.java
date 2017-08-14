package test.TestClone;

/**
 * Created by koreyoshi on 2017/8/14.
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        //引用的复制
//        People people = new People(5,"yu");
//        People people1 = people;
//        System.out.println(people);
//        System.out.println(people1);
        //引用的拷贝

//        Person p = new Person(23, "zhang");
//        Person p1 = (Person) p.clone();
//
//        System.out.println(p);
//        System.out.println(p1);

        //测试深拷贝，浅拷贝
//        Person p = new Person(23, "zhang");
//        Person p1 = (Person) p.clone();
//        System.out.println("p.getName().hashCode() : " + p.getName().hashCode());
//        System.out.println("p1.getName().hashCode() : " + p1.getName().hashCode());
//        String result = p.getName().hashCode() == p1.getName().hashCode()
//                ? "clone是浅拷贝的" : "clone是深拷贝的";
//        System.out.println(result);
        CloneClass cloneClass = new CloneClass(5,"yu");
//        CloneClass cloneClass1 = cloneClass;
        CloneClass cloneClass1 = (CloneClass)cloneClass.clone();

        System.out.println(cloneClass.getName().hashCode());
        System.out.println(cloneClass1.getName().hashCode());




//        Person p = new Person(23, "zhang");
//        Person p1 = p;
//
//        System.out.println(p);
//        System.out.println(p1);
    }
}
