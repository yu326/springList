package test.deepClone;

/**
 * Created by koreyoshi on 2017/9/6.
 */
public class MyTestCloneAbnormal implements Cloneable {
    private String name;
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public MyTestCloneAbnormal(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Object clone() throws CloneNotSupportedException {
        //返回clone的对象
//        return (MyTestCloneAbnormal) super.clone();
        MyTestCloneAbnormal newp = (MyTestCloneAbnormal) super.clone();
        newp.email = (Email)email.clone();
        return newp;
    }

    static class Email implements Cloneable{

        private String contet;
        private String title;

        public String getContet() {
            return contet;
        }

        public void setContet(String contet) {
            this.contet = contet;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }



        public Email(String title, String content) {
            this.title = title;
            this.contet = content;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Email) super.clone();
        }


    }

    public static void main(String[] args) throws CloneNotSupportedException {

        MyTestCloneAbnormal p = new MyTestCloneAbnormal("yu", new Email("9.6中午会议", "今天中午十二点，大家在3楼会议室开会"));
        MyTestCloneAbnormal p1 = (MyTestCloneAbnormal) p.clone();
        p1.setName("张三");
        MyTestCloneAbnormal p2 = (MyTestCloneAbnormal) p.clone();
        p2.setName("李四");
        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.email.getTitle() + "正文是:[" + p.email.getContet() + "]");
        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.email.getTitle() + "正文是:[" + p1.email.getContet() + "]");
        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.email.getTitle() + "正文是:[" + p2.email.getContet() + "]");

        //给p对象设置email内容
        p.email.setContet("yu，你需要早到半小时");

        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.email.getTitle() + "正文是:[" + p.email.getContet() + "]");
        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.email.getTitle() + "正文是:[" + p1.email.getContet() + "]");
        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.email.getTitle() + "正文是:[" + p2.email.getContet() + "]");

    }
}
