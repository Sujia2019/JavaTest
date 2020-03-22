package Algorithm.past.juzhenliancheng;

import java.util.Scanner;

public class Test {
    public static void main(String []args){
        System.out.println("请输入共有几个矩阵");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();   //n1为矩阵个数
        System.out.println("依次输入p，空格隔开：");
        int p[]=new int[n1+1];
        for(int i=0;i<p.length;i++){
            p[i]=sc.nextInt();
        }


        MATRIX matrix = new MATRIX();
        Result r = matrix.MATRIX_CHAIN_ORDER(p);

        int m[][] = r.getM();
        System.out.println("最优值的矩阵为：");
        for(int i=1;i<m.length;i++){
            for(int j=1;j<m[0].length;j++){
                System.out.print(m[i][j]+"  ");
            }
            System.out.println("");
        }
        int s[][]=r.getS();
        r.OUTPUT_OPTIMAL_PARENS(s,1,p.length-1);

    }
}
