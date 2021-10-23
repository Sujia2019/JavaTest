package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class ch1007 {
    public int countSegments(String s) {
        s = s+" ";
        char[] cs = s.toCharArray();
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(cs[i]!=' '){
                for(int j=i;j<s.length();j++){
                    if(cs[j]==' '){
                        res++;
                        i=j;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
