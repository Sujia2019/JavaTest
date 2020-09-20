package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 1.Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * <p>
 * 二叉树的中序遍历
 * <p>
 * 用迭代法
 * <p>
 * <p>
 * 2.实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch0914 {
    // 基于栈的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int lenH = haystack.length();
        int lenN = needle.length();
        if (lenN > lenH) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] needs = needle.toCharArray();
        int len = lenH - lenN + 1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == needs[0]) {
                int j = 1;
                for (; j < lenN; j++) {
                    if (chars[i + j] != needs[j]) {
                        break;
                    }
                }
                if (j == lenN) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        strStr("mississippi", "pi");
    }
}
