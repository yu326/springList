package test.polymorphic;

/**
 * Created by koreyoshi on 2017/8/10.
 */
public class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
    public String show(D obj) {
        return ("DDDD  and D");
    }

}
