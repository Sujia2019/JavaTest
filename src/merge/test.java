package merge;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[]args){
        System.out.println("请输入元素个数");
        Scanner sc = new Scanner(System.in);
        int x1=sc.nextInt();
        System.out.println("请依次输入元素");
        int A[] = new int[x1];
        for(int i=0;i<A.length;i++){
            A[i] = sc.nextInt();
            System.out.print(A[i]+" ");
        }
        System.out.println("");


//        RECMAXMIN re = new RECMAXMIN();
//        MinMax mm=re.REC_MAXMIN(A,0,A.length-1);

//        System.out.println("最小值"+mm.getMin());
//        System.out.println("最大值"+mm.getMax());
//
//        MinMax mm3=re.REC_MAXMIDMIN(A,0,A.length-1);
//        System.out.println("最小值"+mm3.getMin());
//        System.out.println("最大值"+mm3.getMax());

        MERGEMETHOD me = new MERGEMETHOD();
        me.MERGE_SORT(A,0,A.length-1);
        System.out.println("归并排序结果");
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }

    }
}
