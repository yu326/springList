package test.TestInherit;

import lombok.Data;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by koreyoshi on 2018/1/4.
 */

/**
 *  雇员类
 */
@Data
public class Employee {
    private String name;
    private double salary;
    private Date hireday;

    public Employee(String name,double salary,int year,int month,int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.hireday = calendar.getTime();
    }

    public void taiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }
}
