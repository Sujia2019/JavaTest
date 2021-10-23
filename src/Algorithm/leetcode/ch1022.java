package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求众数
 */
public class ch1022 {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int maxCount = 0;
        int secondCount = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            int key = entry.getKey();
            if(value > maxCount){
                secondCount = maxCount;
                second = max;
                maxCount = value;
                max = key;
            }else if(value >= secondCount){
                secondCount = value;
                second = key;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        if(maxCount > len/3){
            arr.add(max);
        }
        if(secondCount > len/3){
            arr.add(second);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        ch1022 c = new ch1022();
        c.majorityElement(arr);
    }
}
