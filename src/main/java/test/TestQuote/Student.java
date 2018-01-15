package test.TestQuote;

import lombok.Data;

/**
 * Created by koreyoshi on 2018/1/4.
 */
@Data
public class Student {
    private double salary;
    private String name;

    Student(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    public void raiseSalary() {
        salary = salary * 1.2;
    }

    public static void swap(Student a, Student b) {
        Student tmp = a;
        System.out.println("Before swap: a name :[ " + a.getName() + " ],salary is:[ " + a.getSalary() + " ]");
        System.out.println("Before swap: b name :[ " + b.getName() + " ],salary is:[ " + b.getSalary() + " ]");
        a = b;
        b = tmp;
        System.out.println("After swap: a name :[ " + a.getName() + " ],salary is:[ " + a.getSalary() + " ]");
        System.out.println("After swap: b name :[ " + b.getName() + " ],salary is:[ " + b.getSalary() + " ]");
    }
}
