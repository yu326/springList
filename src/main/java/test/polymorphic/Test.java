package test.polymorphic;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class Test {
    public static void main(String[] args) {
        Wine a = new JNC();
        a.fun1();
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("TestYu --  "+ b.show(d));

//        System.out.println("1--" + a1.show(b));
//        System.out.println("2--" + a1.show(c));
//        System.out.println("3--" + a1.show(d));
//
//        System.out.println("4--" + a2.show(b));
//        System.out.println("5--" + a2.show(c));
//        System.out.println("6--" + a2.show(d));
//        System.out.println("7--" + b.show(b));
//        System.out.println("8--" + b.show(c));
//
//        System.out.println("9--" + b.show(d));



    }
}
