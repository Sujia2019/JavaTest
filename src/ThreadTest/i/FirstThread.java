package ThreadTest.i;

public class FirstThread extends Thread{
    private int i;
    public FirstThread(String name){
        super(name);
    }
    public void run(){
        for (;i<2;i++){
            System.out.println(this.getName()+"---"+i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            System.out.println(Thread.currentThread().getName());
            if(i==1){
                new FirstThread("aaa").start();
                new FirstThread("bbb").start();
            }
        }
    }
}
