package ThreadTest.TestBank;

import ThreadTest.bank.TransferRunnable;
import org.junit.Test;

import java.util.Random;

import static ThreadTest.bank.UnsynchBankTest.INITIAL_BALANCE;

/**
 * Created by korey on 2017/11/5.
 */
public class TestBank{


    private double[] accounts;
    private int idx;

    public TestBank(int n, double initialBalance) {
        accounts = new double[n];
        for(int i =1;i<n;i++){
            accounts[i] = initialBalance;
        }
    }
    public double getTotalBalance()
    {
        double sum = 0;

        for (double a : accounts)
            sum += a;

        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size()
    {
        return accounts.length;
    }

    public TestBank() {

    }

    public void run() {

    }

    public synchronized void transfer(int from, int to, double amount)
    {
//      bankLock.lock();
        try{
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }finally {
//         bankLock.unlock();
        }

    }
    public int getIntRandom(int maxValue) {

        int max = maxValue;
        int min = 0;
        Random random = new Random();

//        int s = random.nextInt(max)%(max-min+1) + min;
        int s = random.nextInt(max);

        return s;
    }

    public static void main(String[] args) throws InterruptedException {
        TestBank testBank = new TestBank(100, 1000);
        int i = 0;
        for (i = 0; i < 1000; i++) {
            TestTransferRunable r = new TestTransferRunable(testBank, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }


}
