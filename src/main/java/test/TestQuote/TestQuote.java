package test.TestQuote;

/**
 * Created by koreyoshi on 2018/1/4.
 */

import org.junit.Test;

import static test.TestQuote.Student.swap;

/**
 * 测试类
 * 测试方法参数 按值调用还是按引用调用
 */
public class TestQuote {
    /**
     * 验证基本类型
     *
     * @param args
     */
    public static void main(String[] args) {
        //基本类型是按值调用，raiseSalary方法的salary值是main方法中salary值的一个copy。也就是12000.08
        //乘以1.2，又赋值给那个copy的值。然后方法结束这个copy的值也就不再使用，
        // 调用raiseSalary方法后,发现salary的值仍是12000.08
        System.out.println("\nTest BasicTypeValueQuote :");
        double salary = 12000.08;
        System.out.println("Before : salary is:" + salary);
        raiseSalary(salary);
        System.out.println("After : salary is:" + salary);
    }

    public static void raiseSalary(double salary) {
        salary = salary * 1.2;
    }

    /**
     * 验证类对象
     */
    @Test
    public void test() {
        //student被初始化为yu值的拷贝，这是一个对象的引用
        //调用raiseSalary方法，yu和student同时饮用的Student对象的salary提高了
        //方法结束后，student不再使用，而变量yu则继续引用那个对象
        System.out.println("\nTest ObjectValueQuote :");
        Student yu = new Student("yu", 12);
        System.out.println("Before : salary is:" + yu.getSalary());
        yu.raiseSalary();
        System.out.println("After : name is:[ " + yu.getName() + " ],salary is:[ " + yu.getSalary() + " ]");
    }

    /**
     * 反例 -- 证实java不是按引用传递的
     */
    @Test
    public void test1() {
        System.out.println("\nTest swap:");
        Student yu = new Student("yu", 12);
        Student yi = new Student("koreyoshi", 24);
        System.out.println("Before : a name :[ " + yu.getName() + " ],salary is:[ " + yu.getSalary() + " ]");
        System.out.println("Before : b name :[ " + yi.getName() + " ],salary is:[ " + yi.getSalary() + " ]");
        swap(yu, yi);
        System.out.println("After : a name :[ " + yu.getName() + " ],salary is:[ " + yu.getSalary() + " ]");
        System.out.println("After : b name :[ " + yi.getName() + " ],salary is:[ " + yi.getSalary() + " ]");
    }

}
