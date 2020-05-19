package Algorithm.leetcode;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch0516 {
    public static int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int[] res = new int[]{-1,-1};
        if(i==j&&nums[i]==target){
            res[0]=i;
            res[1]=j;
            return res;
        }
        while (i<j){
            if(nums[i]!=target) {
                i++;
            }
            if(nums[j]!=target) {
                j--;
            }
            if(nums[i]==target&&target==nums[j]){
                res[0]=i;
                res[1]=j;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        searchRange(test,8);
    }
}
