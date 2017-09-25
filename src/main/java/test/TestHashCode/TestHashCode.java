package test.TestHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by koreyoshi on 2017/9/15.
 */
public class TestHashCode {
    /***************************     验证hashcode和对象相等的关系
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int hashCode() {
        return i % 10;
    }

    public final static void main(String[] args) {
        TestHashCode a = new TestHashCode();
        TestHashCode b = new TestHashCode();
        a.setI(1);
        b.setI(1);
        Set<TestHashCode> set = new HashSet<TestHashCode>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }

     ***************************     验证hashcode和对象相等的关系                   */

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TestHashCode)) {
            return false;
        }
        TestHashCode other = (TestHashCode) object;
        if (other.getI() == this.getI()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return i % 10;
    }

    public final static void main(String[] args) {
        TestHashCode a = new TestHashCode();
        TestHashCode b = new TestHashCode();
        a.setI(1);
        b.setI(1);
        Set<TestHashCode> set = new HashSet<TestHashCode>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);

    }


}
