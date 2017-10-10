package test.testArrayCopy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by korey on 2017/9/7.
 */
public class Test {

    public static void main(String[] args) {

        int[] lucyNums = {1,2,3,5};
        System.out.println(lucyNums[3]);
        int[] copyArray = Arrays.copyOf(lucyNums,10);
        copyArray[3] = 2;
        //        for(int i=0;i<copyArray.length;i++){
//            System.out.println(copyArray[i]);
//        }
        System.out.println(lucyNums[3]);
        System.out.println(copyArray[3]);

    }
}
