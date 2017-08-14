package test.TestClone;

/**
 * Created by koreyoshi on 2017/8/14.
 */
class CloneClass implements Cloneable {

    private int age;
    private String name;

    public CloneClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public CloneClass() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

//重写clone方法

    public Object clone() {

        CloneClass o = null;

        try {

            o = (CloneClass) super.clone();

        } catch (CloneNotSupportedException e) {

            e.printStackTrace();

        }

        return o;

    }

}
