package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ch0927 {
    public static void main(String[] args) {
        int [] a1 = new int[]{1,2,2,1};
        int [] a2 = new int[]{2,2};
        int [] res = intersect(a1,a2);
        for (int v: res){
            System.out.println(v);
        }
    }

    // [1,2,2,1]
    // [2,2]
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int j = 0;
        int i = 0;
        int k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int []res ;
        if (len1>len2){
            res = new int[len2];
        }else{
            res = new int[len1];
        }
        while(i<len1&&j<len2){
            if(nums1[i]==nums2[j]){
                res[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }
}
