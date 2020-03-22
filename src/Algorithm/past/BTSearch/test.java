package Algorithm.past.BTSearch;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void BubbleSort(int a[]){//冒泡排序
        for(int i=1;i<a.length-1;i++){
            for(int j=1;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static int Search(int a[],int v,int low,int high){
        if(low>high) return 0;
        int mid=(low+high)/2;
        if(v==a[mid]) return mid;
        if(v<a[mid]) return Search(a,v,low,mid-1);
        else return Search(a,v,mid+1,high);
    }

    public static void main(String[] args){
        System.out.println("输入随机生成的数的范围0-?");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        Random r = new Random(n1);
        System.out.println("输入生成随机数的个数");
        int n2 = sc.nextInt();
        int a[] = new int[n2];

        for(int i=1;i<a.length;i++){
            a[i] = r.nextInt(n1);
            System.out.print(a[i]+" ");
            if(i%10==9){
                System.out.println("");
            }
        }
        BubbleSort(a);
        System.out.println("请输入要查找的数");
        int x=sc.nextInt();
        a[0]=x;
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        System.out.println(Search(a,x,1,a.length+1));
        //返回的是下标

    }
}
