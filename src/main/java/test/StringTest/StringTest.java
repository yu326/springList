package test.StringTest;

import org.junit.Test;

/**
 * Created by koreyoshi on 2017/11/24.
 */
public class StringTest {
    @Test
    public void test() {
//        String s = "+呵呵哒";
//        String s1 = "\\+";
//        String s2 = "\\+";
//        String repDocText = s.replaceAll(s1, s2);
//        System.out.println(repDocText);

        try {


            long i = (long)Math.pow(2,31);
            int i1 = (int)Math.pow(2,30);
            float i2 = (float)i1;
            System.out.println(i);
            System.out.println(i1);
            System.out.println(i2);


//            System.out.println(Float.MIN_VALUE);
//            double f0 = (double) Math.pow(2, 128);
//            double f1 = (double) Math.pow(2, 127);
//            double f2 = (double) Math.pow(2, 24);
//            double f3 = (double) Math.pow(2, 23);
//
//
//            float f4 = (float) (f1 * (1 + (f3 - 1) / f3));
//            float f5 = (float) (f1 * ((f2 - 1) / f3));
//            float f6 = (float) f0;
//            float f7 = (float) (f0 - (f1 / f3));
//
//////            float f3 = (float) Math.pow(-2, -148);
//            System.out.println(f0);
//            System.out.println(f4);
//            System.out.println(f5);
//            System.out.println(f6);
//            System.out.println(f7);
//
//
//            double a = Math.pow(2, -150);
//            double b = Math.pow(2, -23);
//            float f = (float) a;
//            System.out.println(f);
//            float f1 = (float) (a - b);
//            System.out.println(f1);
//            double f0 = (double) Math.pow(2, -149);
//            float f1 = (float) f0;
//            System.out.println(f1);
//            long i = (long)Math.pow(2,23);
//            int i1 = (int)Math.pow(2,24);
//            System.out.println(i);
//            System.out.println(i1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public static void main(String[] args)
//    {
//        int i1 = (int)Math.pow(-2,31);
//        int num = i1;
//        String binaryString = Integer.toBinaryString(num);
//        System.out.println(binaryString);
//        for (int i = 0; i < binaryString.getBytes().length; i++)
//        {
//            System.out.print(get(num, i) + "\t");
//        }
//    }
//
//    /**
//     * @param num:要获取二进制值的数
//     * @param index:倒数第一位为0，依次类推
//     */
//    public static int get(int num, int index)
//    {
//        return (num & (0x1 << index)) >> index;
//    }
}
