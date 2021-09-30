package Algorithm.leetcode;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */
public class ch0925 {
    public int minDistance(String word1, String word2) {
        int res = 0;
        if (word1.equals(word2)){
            return res;
        }
        int len1 = word1.length(); //3  seattt 6
        int len2 = word2.length(); //3  eattt 5
        boolean same[][] = new boolean[len1][len2];
        for (int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    same[i][j] = true;
                }
            }
        }
        for (int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                System.out.print(same[i][j]+" ");
            }
            System.out.println();
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1;i<=len1;i++) {
            dp[i][0] = i;
        }
        for(int i = 1;i<=len2;i++) {
            dp[0][i] = i;
        }
        for(int i = 1;i<=len1;i++) {
            for(int j = 1;j<=len2;j++) {
                if(chars1[i-1]==chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[len1][len2];
//        return len1+len2-res;
    }

    public static void main(String[] args) {
        ch0925 c = new ch0925();
        c.minDistance("seat","seat1");
    }
}
