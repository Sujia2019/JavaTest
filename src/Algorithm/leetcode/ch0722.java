package Algorithm.leetcode;

// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
// 👍 505 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class ch0722 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]=digits[i]+1;
                return digits;
            }else{
                digits[i]=0;
            }
        }
        int[] dis = new int[len+1];
        dis[0]=1;
        for(int i=0;i<len;i++){
            dis[i+1]=digits[0];
        }
        return dis;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0};
        plusOne(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)