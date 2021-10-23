package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 */
public class ch1020 {
    public int minMoves(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int minIndex = 0;
        for(int i=0;i<nums.length;i++){
            int index = nums[i];
            if(index<min){
                min = index;
                minIndex = i;
            }else{
                res += index - min;
                nums[i] = min;
            }
        }
        for(int i=0;i<minIndex;i++){
            res += nums[i] - min;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[10];
    }
}
