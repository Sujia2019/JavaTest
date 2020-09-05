package ThreadTest.deadlock;
class C{
    int i=0;
    public synchronized void doAdd(){
        i++;
        System.out.println("A:"+i);
    }

}
public class Test2 {
    public static void main(String[] args) {
        boolean flag = false;

        if(flag){

        }
    }
}
