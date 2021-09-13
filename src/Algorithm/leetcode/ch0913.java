package Algorithm.leetcode;

import java.util.*;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都 互不相同
 *
 */
public class ch0913 {

    private int isSame(int[] a, int[] b, int[] c){
        int dis1 = (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
        int dis2 = (a[0]-c[0])*(a[0]-c[0])+(a[1]-c[1])*(a[1]-c[1]);
        if (dis1 == dis2){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        ch0913 c = new ch0913();
        c.numberOfBoomerangs(test);
        System.out.println(result);
    }
    private static int result = 0;
    // 排列组合超时了
//    private  void numberOfBoomerangs(int[][] points) {
//        List<Integer> iL = new ArrayList<>();
//        plzh(new ArrayList<>(),iL, 3 ,points);
//    }
    private  int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        if(n<3){
            return 0;
        }
        int count = 0;
        for (int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            // dist count  以 x1 y1 为中心的，后面两个可以组合，也就是Am2
            Map<Integer,Integer> maps = new HashMap<>();
            for(int j=0;j<n;j++){
                if(j!=i){
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int dist = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
                    maps.put(dist,maps.getOrDefault(dist,0)+1);
                }
            }
            for(Map.Entry<Integer,Integer> entry : maps.entrySet()){
                int size = entry.getValue();
                if (size > 1){
                    count += size*(size-1);
                }
            }
        }
        return count;
    }


    private  void plzh(List<int[]> s, List<Integer> iL, int m,int[][] points) {
        if(m == 0) {
            int[] a = s.get(0);
            int[] b = s.get(1);
            int[] c = s.get(2);
            result+=isSame(a,b,c);
            return ;
        }
        List<Integer> iL2;
        for(int i = 0; i < points.length; i++) {
            iL2 = new ArrayList<>(iL);
            if(!iL.contains(i)) {
                List<int[]> index = new ArrayList<>(s);
                index.add(points[i]);
                iL2.add(i);
                plzh(index, iL2, m-1, points);
            }
        }
    }
}

