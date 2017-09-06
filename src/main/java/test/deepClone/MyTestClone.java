package test.deepClone;

/**
 * Created by koreyoshi on 2017/9/6.
 */
public class MyTestClone implements Cloneable {
    private String name;
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public MyTestClone(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Object clone() throws CloneNotSupportedException {
        MyTestClone newp = (MyTestClone) super.clone();
        newp.email = (Email)email.clone();
        return newp;
    }

    static class Email implements Cloneable{

        private String contet;

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

        private String title;

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
        //正常
//        MyTestClone p = new MyTestClone("yu", "今天12点在会议室开会");
//        MyTestClone p1 = (MyTestClone) p.clone();
//        p1.setName("张三");
//        MyTestClone p2 = (MyTestClone) p.clone();
//        p2.setName("李四");
//        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.getContent());
//        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.getContent());
//        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.getContent());

        //output
//        给[ yu ]的邮件: 今天12点在会议室开会
//        给[ 张三 ]的邮件: 今天12点在会议室开会
//        给[ 李四 ]的邮件: 今天12点在会议室开会
//

        //如果想让yu早来半个小时
//        MyTestClone p = new MyTestClone("yu", "今天12点在会议室开会");
//        MyTestClone p1 = (MyTestClone) p.clone();
//        p1.setName("张三");
//        MyTestClone p2 = (MyTestClone) p.clone();
//        p2.setName("李四");
//
//        p.setContent("今天12点在会议室开会,你提前半小时到");
//        System.out.println(p);
//        System.out.println(p1);
//        System.out.println(p2);

//        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.getContent());
//        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.getContent());
//        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.getContent());
        //output
//        给[ yu ]的邮件: 今天12点在会议室开会,你提前半小时到
//        给[ 张三 ]的邮件: 今天12点在会议室开会
//        给[ 李四 ]的邮件: 今天12点在会议室开会

        MyTestClone p = new MyTestClone("yu", new Email("9.6中午会议", "今天中午十二点，大家在3楼会议室开会"));
        MyTestClone p1 = (MyTestClone) p.clone();
        p1.setName("张三");
        MyTestClone p2 = (MyTestClone) p.clone();
        p2.setName("李四");
        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.email.getTitle() + "正文是:[" + p.email.getContet() + "]");
        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.email.getTitle() + "正文是:[" + p1.email.getContet() + "]");
        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.email.getTitle() + "正文是:[" + p2.email.getContet() + "]");


        p.email.setContet("yu，你需要早到半小时");
        p1.email.setContet("张三，你需要早到半小时");
        p2.email.setContet("李四，你需要早到半小时");

        System.out.println("给[ " + p.getName() + " ]的邮件: " + p.email.getTitle() + "正文是:[" + p.email.getContet() + "]");
        System.out.println("给[ " + p1.getName() + " ]的邮件: " + p1.email.getTitle() + "正文是:[" + p1.email.getContet() + "]");
        System.out.println("给[ " + p2.getName() + " ]的邮件: " + p2.email.getTitle() + "正文是:[" + p2.email.getContet() + "]");

    }

}
