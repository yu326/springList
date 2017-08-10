package test.polymorphic;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}








