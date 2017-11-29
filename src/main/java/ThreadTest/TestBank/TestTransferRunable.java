package ThreadTest.TestBank;

import java.util.Random;

/**
 * Created by korey on 2017/11/5.
 */
public class TestTransferRunable implements Runnable {


    private TestBank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TestTransferRunable(TestBank b, int from, double max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
        }
    }


    public int getIntRandom() {

        int max = 8;
        int min = 0;
        Random random = new Random();

//        int s = random.nextInt(max)%(max-min+1) + min;
        int s = random.nextInt(max);
        System.out.println(s);
        return s;
    }
}
