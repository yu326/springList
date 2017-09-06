package test.deepClone;

/**
 * Created by koreyoshi on 2017/9/5.
 */
public class Person implements Cloneable {


    public Computer computer;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(Computer computer) {
        this.computer = computer;
    }

    public Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
//        Person newPal = (Person) super.clone();
//        newPal.computer = (Computer) computer.clone();
//        return newPal;
    }

    static class Computer implements Cloneable {
        public Computer() {

        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Computer) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Person  p = new Person(25,"yu");
        Person p = new Person(new Computer());
        Person p1 = (Person) p.clone();
        System.out.println(p1 == p);

        System.out.println(p.computer == p1.computer);
        System.out.println();


    }
}


