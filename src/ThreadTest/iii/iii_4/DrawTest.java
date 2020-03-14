package ThreadTest.iii.iii_4;

public class DrawTest {
    public static void main(String[] args) {
        Account a = new Account("1234567",1000);
        new DrawThread("甲",a,600).start();
        new DrawThread("乙",a,600).start();
    }

    //为什么始终是甲在前呢？

}
