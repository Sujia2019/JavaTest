package ThreadTest.iii.iii_4;

public class DrawThread extends Thread {


    private double drawAmount;
    private Account account;

    public DrawThread(String name,Account account,double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    public void run(){
        account.draw(drawAmount);
    }
}
