package test.TestInherit;

import org.junit.Test;

/**
 * Created by koreyoshi on 2018/1/4.
 */
public class ManagerTest {
    /**
     * 关于继承的例子
     * 雇员只有工资，经理则还有奖金
     * 经理类继承雇员类，并在其基础上加上奖金
     * 并且重写getSalary方法，返回其工资和奖金的总和就好了
     */
    @Test
    public void test() {
        System.out.println("Test Employees start~~ ");
        Employee[] employees = new Employee[3];
        Manager boss = new Manager("yuyi", 1, -1230, 12, 12);
        boss.setBonus(1000);
        employees[0] = boss;
        employees[1] = new Employee("yu", 1, 1992, 10, 23);
        employees[2] = new Employee("yi", 1, 1992, 10, 23);
        for (Employee e : employees) {
            System.out.println("name is:[ " + e.getName() + " ],salary:[ " + e.getSalary() + " ]");
        }
        System.out.println("Test Employees end~~ ");
    }
}
