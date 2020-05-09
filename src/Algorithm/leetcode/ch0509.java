package Algorithm.leetcode;

public class ch0509 {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int r = 0;
        int i=0;
        int j=i+r+1;
        out:while (i<length&&j<length){
            while (true){
                if(nums[i]<nums[j]){
                    nums[i+1]=nums[j];
                    break;
                }else{
                    r=r+1;
                    j=j+1;
                }
                if(j==length){
                    break out;
                }
            }
            i=i+1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(removeDuplicates(nums));
    }
}
