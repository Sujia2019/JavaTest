package junitTest;

import org.junit.Test;

public class ch1 {
    public static void doWork(int x,int y,int z){
        double k=0,j=0;
        if((x>3)&&(z<10)){
            k=x*y-1;
            j=Math.sqrt(k);
        }
        if((x==4)||(y>5)){
            j=x*y+10;
        }
        j=j%3;
    }

    @Test
    public void test(){

    }
}
