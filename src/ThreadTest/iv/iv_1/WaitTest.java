package ThreadTest.iv.iv_1;

public class WaitTest {
    public static void main(String[] args) {
        final WaitTest w = new WaitTest();
        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    w.accessBlock();
                }
            }).start();
        }
    }

    private Object lock = new Object();
    private boolean isAccess=true;
    private boolean flag=true;
    public void accessBlock(){
        if(!isAccess){
            synchronized (lock){
                try{
                    System.out.println(Thread.currentThread().getName()+"线程被堵塞，等待中...");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        isAccess = false;
        System.out.println(Thread.currentThread().getName()+"线程访问中...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始操作---------");
        System.out.println(Thread.currentThread().getName() + "操作中-----------");
        System.out.println(Thread.currentThread().getName() + "结束操作---------");

        if(flag){
            flag=false;
            synchronized (lock){
                lock.notifyAll();
            }
        }

    }
}
