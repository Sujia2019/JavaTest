package ThreadTest.xi;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
//多线程递推RecursiveActionTest
//多线程递归RecursiveTaskTest
public class RecursiveTaskTest {

    public final static ForkJoinPool mainPool = new ForkJoinPool();

    public static void main(String[] args) {
        int n=4;
        int[] a = new int[n];
        Random rand = new Random();
        for(int i=0;i<n;i++){
            a[i] =rand.nextInt(1000);
        }
        SubRecursiveTask task = new SubRecursiveTask(a,0,n);
        int count = mainPool.invoke(task);
        for(int i=0;i<n;i++){
            System.out.println(a[i]+" ");
        }
        System.out.println("\n数组中共出现了"+count+"个1");
    }

}

class SubRecursiveTask extends RecursiveTask<Integer>{
    @Override
    protected Integer compute() {
        int result=0;
        if(end-beg>1){
            int mid=(beg+end)/2;
            SubRecursiveTask t1 = new SubRecursiveTask(a,beg,mid);
            SubRecursiveTask t2 = new SubRecursiveTask(a,mid,end);
            System.out.println("t1---"+beg+"----"+mid);
            System.out.println("t2---"+mid+"----"+end);
            invokeAll(t1,t2);
            System.out.println("++++++++++++++++++++");
            try{
                int t1res = t1.get();
                int t2res = t2.get();
                result=t1res+t2res;
                System.out.println("------"+t1res+"------"+t2res);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            result=count(a[beg]);
        }
        return result;
    }
    private int count(int n){
        int result=0;
        while (n>0){
            if(n%10==1){
                result++;
            }
            n=n/10;
        }
        System.out.println("++++++++"+result);
        return result;
    }

    private static final long serialVersionUID = 1L;
    private int[] a;
    private int beg;
    private int end;

    public SubRecursiveTask(int[] a,int beg,int end){
        super();
        this.a=a;
        this.beg=beg;
        this.end=end;
    }
}
