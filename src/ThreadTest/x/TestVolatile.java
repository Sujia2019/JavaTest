package ThreadTest.x;

class Test{
    public void dis(){
        System.out.println("ok");
    }
}
public class TestVolatile {
    static  volatile boolean flag=true;
    static  Test t = null;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (flag){
                    i++;
                }
                t.dis();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t=new Test();
                flag=false;
            }
        }).start();
    }
}
