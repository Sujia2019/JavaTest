package Algorithm.past.juzhenliancheng;

public class MATRIX {

    public Result MATRIX_CHAIN_ORDER(int p[]){//假设4个矩阵，则p里存了五个值
        Result r = new Result();
        int m[][] = new int[p.length][p.length];//用一个5x5矩阵，0行0列不看，用1234作下标。
        int s[][] = new int[p.length][p.length];
        int n=p.length;   //n为矩阵个数
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                m[i][j]=0;//初始化
            }
        }
        for(int l=2;l<n;l++){  //填第len条对角线(链长度控制) 从2到n
            for(int i=1;i<n-l+1;i++){//从第i个矩阵开始乘到
                int j=i+l-1;                       //第j个矩阵
                m[i][j]=100000;      //给第i列第j行赋初值
                for(int k=i;k<=j-1;k++){  //k表示所有可能断开的位置
                    int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<m[i][j]) {
                        m[i][j]=q;//保存最优值
                        s[i][j]=k;//保存最优断开位置
                    }
                }
            }
        }
        r.setM(m);
        r.setS(s);
        return r;
    }
}
