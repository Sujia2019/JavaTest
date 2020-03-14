package ThreadTest.iii.iii_1;

public class DrawTest {

    public static void main(String[] args) {
        Account acct = new Account("1234567",1000);
        new DrawThread("甲",acct,800).start();
//        try {
//            Thread.sleep(1000);
            new DrawThread("乙",acct,800).start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //因为没有给atm里的钱上锁吧


    }


}
