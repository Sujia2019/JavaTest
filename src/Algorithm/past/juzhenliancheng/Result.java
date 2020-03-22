package Algorithm.past.juzhenliancheng;

public class Result {
    public int[][] m;   // 用于记录矩阵乘积，开销
    public int[][] s;//用于找分开的括号位置
    public int[][] getS() {
        return s;
    }

    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }

    public void setS(int[][] s) {
        this.s = s;
    }

//    public void PrintBestResult(){
//        System.out.println("最优值的矩阵为：");
//        for(int i=1;i<m.length;i++){
//            for(int j=1;j<m[0].length;i++){
//                System.out.println(m[i][j]+"  ");
//            }
//            System.out.println("");
//        }
//    }
    public void OUTPUT_OPTIMAL_PARENS(int[][] s,int i,int j){
        if(i==j){
            System.out.print("A"+i);
        }
        else{
            System.out.print("(");
            OUTPUT_OPTIMAL_PARENS(s,i,s[i][j]);
            OUTPUT_OPTIMAL_PARENS(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
