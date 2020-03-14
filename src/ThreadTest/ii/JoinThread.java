package ThreadTest.ii;

import java.util.Random;

public class JoinThread extends Thread{
    public JoinThread(String name){
        super(name);
    }

    public void run(){
        try{
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(this.getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new JoinThread("新线程").start();
        for(int i=0;i<100;i++){
            JoinThread jt = new JoinThread("被join的线程"+i);
            jt.start();
            jt.join();
        }
    }
}
