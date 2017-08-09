package test.Service;

import java.util.Date;

/**
 * Created by koreyoshi on 2017/8/9.
 */
public class DateInterval extends Pair<Date> {

    public DateInterval(Date first, Date second){
        super(first, second);
    }
    @Override
    public void setSecond(Date second) {
        super.setSecond(second);
    }
    @Override
    public Date getSecond(){
        return super.getSecond();
    }

//    public void setSecond(Object obj){
//        System.out.println("覆写超类方法！");
//    }
    public static void main(String[] args) {
        DateInterval interval = new DateInterval(new Date(), new Date());
        Pair<Date> pair = interval;//超类，多态
        Date date = new Date(4000, 1, 1);
        System.out.println("原来的日期："+pair.getSecond());
        System.out.println("set进新日期："+date);
        pair.setSecond(date);
        System.out.println("执行pair.setSecond(date)后的日期："+pair.getSecond());

    }
}
