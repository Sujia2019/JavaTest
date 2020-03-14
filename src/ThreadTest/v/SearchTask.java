package ThreadTest.v;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable{

    public SearchTask(Result result){
        this.result=result;
    }
    private Result result;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread start "+name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n",name);
            return;
        }
        System.out.println("Thread end "+name);
    }
    private void doTask()throws InterruptedException{
        Random random = new Random((new Date()).getTime());
        int value=(int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }

    public static void main(String[] args) {

        //创建5个线程，并入group里面进行管理
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for(int i=0;i<10;i++){
            Thread th = new Thread(threadGroup,searchTask);
            th.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //查看group里的所有信息
        System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        //复制group里面的信息
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int i=0;i<threadGroup.activeCount();i++){
            System.out.printf("Thread %s:------%s\n",
                    threads[i].getName(),threads[i].getState());
        }
        waitFinish(threadGroup);
        //将group里面的所有线程都给interrupt
        threadGroup.interrupt();

    }


    private static void waitFinish(ThreadGroup threadGroup){
        while(threadGroup.activeCount()>9){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Result{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}

