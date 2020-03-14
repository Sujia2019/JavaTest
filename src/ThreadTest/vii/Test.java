package ThreadTest.vii;

class MyThread extends Thread{
    public String getXxx(){
        return xxx;
    }

    public void setXxx(String name){
        this.xxx=name;
    }
    private String xxx;

    @Override
    public void run() {
        System.out.println(xxx);
    }
}
class MyRunnable implements Runnable{

    public String getXxx(){
        return xxx;
    }
    public void setXxx(String name){
        xxx=name;
    }
    private String xxx;
    @Override
    public void run() {
        System.out.println(xxx);
    }
}
public class Test {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread t = new Thread(myRunnable);
        myRunnable.setXxx("xxx");
        MyRunnable myRunnable11 = new MyRunnable();
        myRunnable11.setXxx("ttt");
        Thread t1 = new Thread(myRunnable11);
        t.start();
        t1.start();
    }
}
