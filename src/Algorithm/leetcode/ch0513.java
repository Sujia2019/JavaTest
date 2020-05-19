package Algorithm.leetcode;
/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch0513 {
    public static int[][] rotate(int[][] matrix) {

        int length = matrix.length;
        for(int y=0;y<length/2;y++){
            int end = length - y - 1;
            for(int x = 0; x<end- y; x++){
                int temp = matrix[y][y + x];
                matrix[y][y + x] = matrix[end - x][y];
                matrix[end - x][y] = matrix[end][end - x];
                matrix[end][end - x] = matrix[y + x][end];
                matrix[y + x][end] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int [][] aa = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        rotate(aa);
        for (int[] ints : aa) {
            for (int j = 0; j < aa.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
//        System.out.println(aa[1][0]);
    }
}
