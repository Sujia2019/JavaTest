package ThreadTest.i;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SecondThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for(;i<100;){
            System.out.println(Thread.currentThread().getName()
            +"   "+i);
//            synchronized (this){
//                i++;
//            }
        }
    }

    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()
            +"   "+i);
            if(i==20){
                SecondThread st = new SecondThread();
                new Thread(st,"新线程1").start();
                new Thread(st,"新线程2222").start();
            }
        }
        long curTime2 = System.currentTimeMillis();
        long fi = curTime2-curTime;
        System.out.println(fi);
    }
}
