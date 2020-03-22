package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * 分治法
 */
public class ch1231 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x1 = nums1.length;
        int x2 = nums2.length;
//        if (x1==0)
//        {
//            if (x2 % 2 == 0)
//                return (nums2[x2 / 2] + nums2[x2 / 2 - 1]) *0.5;
//            return nums2[x2 / 2];
//        }
//        if (x2==0)
//        {
//            if (x1 % 2 == 0)
//                return (nums1[x1 / 2] + nums1[x1 / 2 - 1]) *0.5;
//            if (x1 % 2 != 0)
//                return nums1[x1 / 2];
//        }
        //归并排序
        List<Integer> c = new ArrayList<>();
        int i, j;//分别为nums1,nums2,c的下标
        for (i = 0, j = 0; i < x1&&j < x2;)
        {
            if (nums1[i] < nums2[j])
            {
                c.add(nums1[i]);
                i++;
            }
            else{
                c.add(nums2[j]);
                j++;
            }
        }
        while (i < x1)
        {
            c.add(nums1[i]);
            i++;

        }
        while (j < x2)
        {
            c.add(nums2[j]);
            j++;
        }
        int k = c.size();
        if (k % 2 == 0){
            return (c.get(k/2-1) + c.get(k/2))*0.5;
        }
        else{
            return c.get((k-1)/2);
        }
    }

    //最优

    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        int cnt1 = nums1.length;
        int cnt2 = nums2.length;
        if (cnt1 > cnt2) {
            int tmp = cnt1;
            cnt1 = cnt2;
            cnt2 = tmp;

            int[] tmpArr = nums1;
            nums1 = nums2;
            nums2 = tmpArr;
        }

        int k = (cnt1 + cnt2 + 1) / 2;
        int left = 0;
        int right = cnt1;
        while (left < right) {
            int mid = left + right >>> 1;
            int n = k - mid;
            if (nums2[n - 1] > nums1[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int m = left;
        int n = k - left;

        int c1 = Math.max(
                m <= 0 ? Integer.MIN_VALUE : nums1[m - 1],
                n <= 0 ? Integer.MIN_VALUE : nums2[n - 1]
        );

        if ((cnt1 + cnt2) % 2 == 1) {
            return c1;
        }

        int c2 = Math.min(
                m >= nums1.length ? Integer.MAX_VALUE : nums1[m],
                n >= nums2.length ? Integer.MAX_VALUE : nums2[n]
        );

        return (c1 + c2) * 0.5;
    }
    public static void main(String[] args) {
        ch1231 test = new ch1231();
        int []a = new int[]{1,2};
        int []b = new int[]{3,4};
        System.out.println(test.findMedianSortedArrays(a,b));
    }
}
