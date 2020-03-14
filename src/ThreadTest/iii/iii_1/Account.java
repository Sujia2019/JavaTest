package ThreadTest.iii.iii_1;

public class Account {
    // 封装账户编号、账户余额两个成员变量
    private String accountNo;
    private double balance;

    public Account(){

    }
    // accountNo的setter和getter方法
    public Account(String accountNo,double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    // 因此账户余额不允许随便修改，所以只为balance提供getter方法，
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // 提供一个线程安全draw()方法来完成取钱操作
    public void draw(double drawAmount){
        if(balance >= drawAmount){
            System.out.println(Thread.currentThread().getName()
                    +"取钱！"+drawAmount);

            balance -=drawAmount;
            System.out.println("\t余额为："+balance);
        }else{
            System.out.println(Thread.currentThread().getName()
                    +"取钱失败！余额不足！");
        }
    }

    public int hashCode(){
        return accountNo.hashCode();
    }
    //重写accountNo的hashcode和equals方法
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj!=null
                &&obj.getClass()==Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
















}
