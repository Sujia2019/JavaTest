package Algorithm.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class ch1230 {
    //用时过长
    //我写的垃圾
//    public int lengthOfLongestSubstring(String s) {
//        int x=1;
//        int len = s.toCharArray().length;
//        if(len>0){
//            for(int i=0;i<len;i++){
//                for(int j=i+1;j<len;j++) {
//                    String str = s.substring(i,j);
//                    char c = s.charAt(j);
//                    if(str.indexOf(c)==-1){
//                        int y=j-i+1;
//                        if(y>x) x=y;
//                    }else{
//                        break;
//                    }
//                }
//            }
//            return x;
//        }else{
//            return 0;
//        }
//
//    }

    //最优解


    public static void main(String[] args) {
        ch1230 test = new ch1230();
        int x= test.lengthOfLongestSubstring("asdasdasdawq");
        System.out.println(x);

    }

    private int lengthOfLongestSubstring(String s) {
        int start=0;
        int maxLength=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<=s.length();i++){
            if(i==s.length()){
                maxLength=Math.max(maxLength,i-start);
                break;
            }
            char c = s.charAt(i);
            if(map.containsKey(c)&&map.get(c)>=start){
                maxLength=Math.max(maxLength,i-start);
                start=map.get(c)+1;
            }
            map.put(c,i);
        }
        return maxLength;
    }

    //set:
        public int lengthOfLongestSubstringSet(String s) {
            int i = 0, j = 0, ans = 0;
            int n =  s.length();
            Set<Character> set = new HashSet<>();
            while(i < n && j < n){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    j++;
                    ans = Math.max(j - i, ans);
                }
               else{
                   set.remove(s.charAt(i));
                   i++;
               }
            }
            return ans;
        }

        //数组
        public int lengthOfLongestSubstringArray(String s){
            if (s == null || s.length() == 0) return 0;
            int[] map = new int[128];
            int res = 0;
            for (int i = 0, j = 0; i < s.length(); i++){
                j = Math.max(map[s.charAt(i)], j);
                res = Math.max(res, i - j + 1);
                map[s.charAt(i)] = i+1;
            }
            return res;
        }

        //链表
        public int lengthOfLongestSubstringList(String s) {
            List<Character> list = new ArrayList<Character>();
            int lastRepeatIndex = -1;
            int largeLength = 0;
            int index =0;
            int size =0;
            for(char c:s.toCharArray()){
                index = list.lastIndexOf(c);
                if(index>-1&& lastRepeatIndex <index){
                    size = (list.size()- lastRepeatIndex -1);
                    largeLength = size>largeLength?size:largeLength;
                    lastRepeatIndex = index;
                }
                list.add(c);
            }
            size = (list.size()- lastRepeatIndex -1);
            return size>largeLength?size:largeLength;
        }

}
