package Algorithm.past.Hanoi;

public class Hanoi {

    public void Move(char A,int n,char B){
        System.out.println("move编号为"+n+"的块儿:"+A+"----"+B);
    }
    public int HanoiMove(int n,char X,char Y,char Z){
        if(n==1){
            Move(X,n,Z);
            return 1;
        }
        else{
            int c1=HanoiMove(n-1,X,Z,Y);
            Move(X,n,Z);
            int c2=HanoiMove(n-1,Y,X,Z);
            return c1+c2+1;
        }
    }

}
