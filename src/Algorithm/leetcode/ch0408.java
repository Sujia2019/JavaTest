package Algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 *
 * ????啥是字典序???
 */
public class ch0408 {

    public void swap(int a,int b){
        int temp = a;
        a=b;
        b=temp;
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int k = len-1;
        for(int i=k-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int swap = i+1;
                for(int j=i+1;j<len;j++){
                    if(nums[j]>nums[i]&&nums[j]<nums[swap]){
                        swap=j;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[swap];
                nums[swap] = tmp;
                Arrays.sort(nums,i+1,len);
                return;
            }
        }
        Arrays.sort(nums);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        nextPermutation(a);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

}
