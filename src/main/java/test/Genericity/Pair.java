package test.Genericity;

/**
 * Created by koreyoshi on 2017/8/15.
 */
public class Pair<T> {
    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public Pair(){
        first = null;
        second = null;
    }

}
