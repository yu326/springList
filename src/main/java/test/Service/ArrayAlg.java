package test.Service;

import java.util.Date;

/**
 * Created by koreyoshi on 2017/8/9.
 */
public class ArrayAlg {

    public static int getMiddle(int[] n){
        System.out.println("不是泛型方法");
        return n[n.length/2];
    }
    public static <T> T getMiddle(T[] t){
        System.out.println("泛型方法");
        return t[t.length/2];
    }

    //  public static Object getMiddle(Object[] o){
//      return o[o.length/2];
//  }
    public static void main(String[] args) {
        String[] s = {"AAA","BBB","CCC"};
        Integer[] is = {100,200,300};
        System.out.println(ArrayAlg.<String>getMiddle(s));//在方法名前指定类型
//      System.out.println(<String>getMiddle(s));//不能这样用，虽然调用的是处在同一个类中静态方法,语法问题，<>不能加在方法名前
        Date[] d = {new Date(),new Date(),new Date()};
        System.out.println(ArrayAlg.<Date>getMiddle(d));//其实可以不指定参数，编译器有足够的信息推断出要调用的方法

        System.out.println(ArrayAlg.<Integer>getMiddle(is));
    }


    public static <T extends Comparable> Pair <T> minmax(T[] ts){
        if(ts == null || ts.length == 0){
            return null;
        }
        T min = ts[0];
        T max = ts[0];
        for(int i = 0;i < ts.length;i++){
            System.out.println(ts[i]);
            Boolean res = min.compareTo(ts[i]) > 0;
            if(min.compareTo(ts[i]) > 0){
                min = ts[i];
            }
            if(max.compareTo(ts[i]) < 0){
                max = ts[i];
            }
        }
        return new Pair<T>(min, max);
    }
}
