package ThreadTest.iv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();

        //创建并发访问的账户
        Account myAccount = test.new Account("99999",10000);
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = test.new DrawThread("张三",myAccount,1100);
        Thread t2 = test.new DrawThread("李四",myAccount,100);
        Thread t3 = test.new DrawThread("王五",myAccount,3000);
        Thread t4 = test.new DrawThread("老张",myAccount,4000);
        Thread t5 = test.new DrawThread("老牛",myAccount,5000);
        Thread t6 = test.new DrawThread("我",myAccount,4000);

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

    }

    public class SaveThread extends Thread{
        private String name;
        private Account account;
        private int x;

        SaveThread(String name,Account account,int x){
            this.name=name;
            this.account=account;
            this.x=x;
        }

        public void run(){
            account.saving(x,name);
        }
    }

    public class DrawThread extends Thread{
        private String name;
        private Account account;
        private int x;

        DrawThread(String name,Account account,int x){
            this.name = name;
            this.account=account;
            this.x = x;
        }

        public void run(){
            account.drawing(x,name);
        }
    }

    public class Account{
        private String id;
        private int cash;
        private Lock lock = new ReentrantLock();//账户锁
        private Condition _save = lock.newCondition();//存款条件
        private Condition _draw = lock.newCondition();//取款条件

        Account(String id,int cash){
            this.id = id;
            this.cash= cash;
        }
        public void saving(int x,String name){
            lock.lock();//获取锁
            if(x>0){
                cash +=x;
                System.out.println(name+" 存款:"+x+",当前余额为 "+cash);
            }
            _draw.signalAll();
            lock.unlock();
        }

        public void drawing(int x,String name){
            lock.lock();//获得锁
            try{
                if(cash -x<0){
                    System.out.println(name+ " 取钱失败[余额不足]。当前余额为 "+cash);
                    _draw.await();
                }
                cash -=x;
                System.out.println(name+" 取款"+x+"当前余额为 "+cash);
                _save.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                //Wakes up all waiting threads.
            }
        }
    }
}
