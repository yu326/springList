package test.reflex;

import lombok.Data;

/**
 * Created by koreyoshi on 2017/11/23.
 */
@Data
public class Person {
    private String name;
    private int age;

    //新增一个私有方法
    private void privateMthod(){
    }

    public Person() {
        System.out.println("无参构造器");
    }

    public Person(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
