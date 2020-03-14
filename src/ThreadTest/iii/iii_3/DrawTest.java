package ThreadTest.iii.iii_3;

public class DrawTest {
    public static void main(String[] args) {
        Account a = new Account("1234567",1000);
        new DrawThread("甲",a,800).start();
        new DrawThread("乙",a,800).start();
    }

    /*
     * 测试后，iii_1中无法保证安全，
     *
     * 2中锁了方法
     * 3中锁了一个属性，锁住atm中的钱数，在一个线程操作时，其他线程不可修改
     */
}
