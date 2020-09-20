package Algorithm.leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ch0805 {
//    public static TreeNode createTree(){
//
//    }
private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    public static boolean compareTree(TreeNode tree1,TreeNode tree2){
        if(tree1==null&&tree2==null){
            return true;
        }else{
            if(tree1==null||tree2==null){
                return false;
            }else if(tree1.val==tree2.val){
                boolean c1 = compareTree(tree2.left,tree1.left);
                boolean c2 = compareTree(tree1.right,tree2.right);
                return c1 && c2;
            }else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.right=new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        t2.left=new TreeNode(2);
        t2.right=new TreeNode(3);
        boolean isSame = compareTree(t1,t2);
        System.out.println(isSame);
    }
}

