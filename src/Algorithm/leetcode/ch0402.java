package Algorithm.leetcode;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 */
public class ch0402 {
    public static boolean isNumber(char c){
        return c >= 48 && c <= 57;
    }
    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!isNumber(board[i][j])){
                    continue;
                }
                //行遍历
                for(int k=8;k>j;k--){
                    if(board[i][j]==board[i][k]){
                        return false;
                    }
                }
                //列遍历
                for(int k=8;k>i;k--){
                    if(board[i][j]==board[k][j]){
                        return false;
                    }
                }
                for(int k=i+1;k%3!=0;k++){
                    for(int h=j/3*3;h<j/3*3+3;h++){
                        if(board[i][j]==board[k][h])
                            return false;
                    }
                }
            }
        }
        return true;
    }


    /*
        编写一个程序，通过已填充的空格来解决数独问题。
        一个数独的解法需遵循如下规则：
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
        空白格用 '.' 表示。

        解数独
        回溯法
     */
    public void solveSudoku(char[][] board) {

    }

    public static void main(String[] args) {
        System.out.println(isNumber('4'));
    }
}
