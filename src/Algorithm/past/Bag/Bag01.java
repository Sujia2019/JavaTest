package Algorithm.past.Bag;

import java.util.Scanner;

public class Bag01 {

    public static void main(String[]args){
        Stuff stuff = new Stuff();

        System.out.println("请输入物品数量：");
        Scanner sc =  new Scanner(System.in);
        int n1 = sc.nextInt();    //n1 是物品数量
        Stuff[] s = new Stuff[n1+1];

        System.out.println("请输入背包的承重：");
        int n2 = sc.nextInt();     //n2是背包承重

        for(int i=1;i<=n1;i++) {
            System.out.println("请输入第"+i+"件物品的重量和价值");
            int wg = sc.nextInt();
            int wl = sc.nextInt();
            s[i] = new Stuff(wg,wl);
        }
        System.out.println("初始化完成！");
        Stuff s1 = new Stuff();
        int array[][] =s1.mathord(s, n1+1, n2+1);
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[0].length;j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        int x[]=s1.OUTPUT_SACK(s,array,n1,n2);
        for(int i=1;i<x.length;i++){
            System.out.print(x[i]+" ");
        }
    }
}
