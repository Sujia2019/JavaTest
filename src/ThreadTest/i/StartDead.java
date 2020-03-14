 package ThreadTest.i;

public class StartDead extends Thread{
    private  int i;

    public void run(){
        for(;i<100;i++){
            System.out.println(getName()+"  "+i);
        }
    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();
        for(int i=0;i<300;i++){
            System.out.println(Thread.currentThread().getName()+
                    "  "+i);
            if(i==20){
                sd.start();
                //RUNNABLE
                System.out.println(sd.isAlive()+"  status "+sd.getState());
            }
            if(i>20 &&!sd.isAlive()){
                //TERMINATED
                System.out.println("now status "+sd.getState());
                sd.start();
            }
        }
    }
}
