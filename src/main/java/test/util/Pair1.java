package test.util;

/**
 * Created by koreyoshi on 2017/8/9.
 */
public class Pair1<T extends Comparable> {
    private T first;
    private T second;

    public Pair1(){
        first = null;
        second = null;
    }

    public Pair1(T first, T second){
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first){
        this.first = first;
    }

    public T getFirst(){
        return first;
    }
    public void setSecond(T second){
        this.second = second;
    }
    public T getSecond(){
        return second;
    }
}
