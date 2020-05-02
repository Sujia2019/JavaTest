package Algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class ch0502 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

//        System.out.println(arrangementSelect(nums));
        List<List<Integer>> lists = arrangementSelect(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> arrangementSelect(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        return arrangementSelect(res,nums, new int[n], 0);
    }

    /**
     * 排列选择
     * @param dataList 待选列表
     * @param resultList 前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始
     */
    private static List<List<Integer>> arrangementSelect(List<List<Integer>> res,int[] dataList, int[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            ArrayList<Integer> list = new ArrayList<>();
            for (int value : resultList) {
                list.add(value);
            }
            res.add(list);
            return res;
        }

        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i]==(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(res,dataList, resultList, resultIndex + 1);
            }
        }
        return res;
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     * @param n
     * @return
     */
    public static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }
}
