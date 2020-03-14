package ThreadTest.v;

public class ExHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int a = 5/0;
        System.out.println("aaaaaa程序正常结束！");
    }
}

class MyExHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("--------线程出现了异常-----------"+"\n"+e);
    }
}
