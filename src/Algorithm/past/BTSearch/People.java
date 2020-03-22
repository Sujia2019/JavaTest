package Algorithm.past.BTSearch;

import java.util.Random;
import java.util.Scanner;

public class People {

    public static void main(String args[]){
        System.out.println("请输入随机数的范围1-？");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a[] = new int[]{0,0,0,0,0,0,0,0,0};
        int count = 0;
        Random rd = new Random(n1);

        while(count<a.length){
            boolean flag = true;
            int r = rd.nextInt(n1)+1;
            for(int i=0;i<a.length;i++){
                if(r==a[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                a[count]=r;
                System.out.println(r);
                count++;
            }
        }
    }
}
