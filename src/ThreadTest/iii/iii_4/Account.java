package ThreadTest.iii.iii_4;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    //定义锁对象 可重入独占式锁）
    private final ReentrantLock lock = new ReentrantLock();
    private String accountNo;
    private double balance;

    public Account(){

    }

    public Account(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void draw(double drawAmount){
        lock.lock();
        try{
            if(balance>=drawAmount){
                System.out.println(Thread.currentThread().getName()
                        +"取钱成功!"+drawAmount);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                balance-=drawAmount;
                System.out.println("\t余额为："+balance);
            }else{
                System.out.println(Thread.currentThread().getName()
                        +"取钱失败！余额不足！");
            }

        }finally {
            lock.unlock();
        }
    }
    // 下面两个方法根据accountNo来重写hashCode()和equals()方法
    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null
                && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
