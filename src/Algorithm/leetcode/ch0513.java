package Algorithm.leetcode;

public class ch0513 {
    public void rotate(int[][] matrix) {
        int x = matrix.length-1;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j<=x){
                    int dx = i-x+j;
                    int dy = 2*j-i+1;
                    //此位置被谁替换
//                    matrix[i][j];
                    //此位置的值要替换谁
                    int index = matrix[dx][dy];
                    matrix[dx][dy]=matrix[i][j];

                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] aa = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        System.out.println(aa[1][2]);
    }
}
