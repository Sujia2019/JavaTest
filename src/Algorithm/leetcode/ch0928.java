package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ch0928 {
    static int ans = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(root != null) {
            list.add(root.val);
            dfs(root, list, targetSum);
        }
        return ans;
    }
    public static void dfs(TreeNode root, List<Integer> list, int targetSum){
        int sum = list.get(list.size() - 1);

        for(int i = 0; i < list.size() - 1; i++){
            if(sum - list.get(i) == targetSum) ans++;
        }

        if(root.left != null){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(root.left.val + sum);
            dfs(root.left, temp, targetSum);
        }
        if(root.right != null){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(root.right.val + sum);
            dfs(root.right, temp, targetSum);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val=10;
        TreeNode rl = new TreeNode();
        rl.val=5;
        TreeNode rr = new TreeNode();
        rr.val=-3;
        TreeNode rll = new TreeNode();
        rll.val=3;
        TreeNode rrr = new TreeNode();
        rrr.val=11;
        TreeNode rlr = new TreeNode();
        rlr.val=2;
        TreeNode rlrr = new TreeNode();
        rlrr.val=1;
        TreeNode rlll = new TreeNode();
        rlll.val=3;
        TreeNode rllr = new TreeNode();
        rllr.val=-2;
        root.left = rl;
        root.right = rr;
        rl.left = rll;
        rl.right = rlr;
        rll.left = rlll;
        rll.right = rllr;
        rr.right = rrr;
        rlr.right = rlrr;

        int res = pathSum(root,8);
        System.out.println(res);
    }
    public static int preOrderRe(TreeNode biTree,int val){
        System.out.println(biTree.val);
        TreeNode leftTree = biTree.left;
        int value = biTree.val;
        if(leftTree!=null){
            value = value+leftTree.val;
            return preOrderRe(leftTree,value);
        }
        TreeNode rightTree = biTree.right;
        if(rightTree!=null){
            value = value+rightTree.val;
            return preOrderRe(rightTree,value);
        }
        return val;
    }



    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
