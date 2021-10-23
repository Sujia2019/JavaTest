package Algorithm.leetcode;

import java.util.HashMap;
import java.util.List;

public class ch1010 {
    public static int arrangeCoins(int n) {
        int i=1;
        while (true){
            long full = (1+i)*i/2;
            if(full < n){
                i++;
            }else if(full == n){
                return i;
            }else{
                return i-1;
            }
        }
    }

    public static String destCity(List<List<String>> paths) {
        HashMap<String,Integer> starts = new HashMap<>();
        for (List<String> path : paths) {
            String start = path.get(0);
            starts.putIfAbsent(start, 1);
        }
        for(List<String> path: paths){
            if (!starts.containsKey(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
