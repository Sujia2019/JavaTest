package Algorithm.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch0401 {

    /*
    思路：
    在m,n一定时，m和n越接近，mn乘积越大
    从头尾开始遍历array[]
    找最大的两个数
    存入map<array[i],i>,  xxxxxxxxxxxxxx


    我放弃了,还是双指针香
     */


    /**
     * 用时144ms
     *
     * 分析，差距在于，比较的次数可能还是过多，导致耗时
     * 也没有灵活使用java的api
     * 想用java的集合试试，没做出来，最终还是forfor双指针提交了。。。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxRes = 0;
        for(int i=0;i<height.length;i++){
            for(int j=height.length-1;(j-i)!=0;j--){
                int n = j-i;
                int temp;
                if(height[i]>=height[j]){
                    temp = n*height[j];
                    if(temp>maxRes){
                        maxRes=temp;
                    }
                }else{
                    temp = n*height[i];
                    if(temp>maxRes){
                        maxRes=temp;
                    }else{
                        break;
                    }
                }
            }
        }
        return maxRes;
    }

    /**
     * 大佬的方法 用时4ms
     * @param height
     * @return
     */
    public static int maxArea0(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        int []array = new int[]{1,8,8,8,8,8,8,3,7};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println();
        System.out.println(maxArea(array));
    }
}
