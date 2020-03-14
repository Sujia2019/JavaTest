package ThreadTest.vii;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class StopTest {
    public static void main(String[] args) {
        Task t = new Task();
        Thread t1 = new Thread(t,"aaaaa");
        t1.start();
        Thread t2 = new Thread(t,"bbbbb");
        t2.start();
        t.stop("aaaaaaaaaa");
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        flag.set(true);
        while (flag.get()){
            System.out.println(Thread.currentThread().getName());
            if(name.equals(Thread.currentThread().getName())){
                flag.set(false);
            }
            try{
                //这里只要sleep了为啥就不会寸呢，一定是ababab交互的
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //这是个原子操作
    private ThreadLocal<Boolean> flag = new ThreadLocal<>();
    private String name = "";
    public Task(){
        System.out.println(Thread.currentThread().getName());
    }
    public void stop(String threadNmae){
        this.name=threadNmae;
    }
}
