package test.TestInherit;

/**
 * Created by koreyoshi on 2018/1/4.
 */

import lombok.Data;

/**
 * 经理类 -- 需要在雇员类的基础上加上奖金
 */
@Data
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

}
