package Algorithm.leetcode;

/**
 *  密钥
 *
 */
public class ch1004 {

    public String licenseKeyFormatting(String s, int k) {
        s.replace("-","");
        int len = s.length();
        int yu = len%k;
        int div = (k-yu)/k;
        StringBuilder res = new StringBuilder("");
        String start = "";
        if(yu != 0 && div !=1){
            start = s.substring(0,yu);
        }
        res.append(start);
        for (int i=1;i<div;i++){
            res.append("-");
            res.append(s, yu*i, yu*(i+1));
        }
        return res.toString();
    }

}
