package Algorithm.leetcode;
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ch0517 {
    /*
    执行用时 :
        1 ms, 在所有 Java 提交中击败了35.54%的用户
    内存消耗 :
        39.2 MB, 在所有 Java 提交中击败了5.43%的用户
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> listMap = new HashMap<>();
        int len = 0;
        ListNode noHead = head;
        if(head.next==null){
            return null;
        }
        while (noHead!=null){
            ListNode index = noHead;
            noHead = noHead.next;
            listMap.put(len++,index);
        }
        if(len==n){
            return head.next;
        }
        ListNode node = listMap.get(len-n);
        ListNode pr = listMap.get(len-1-n);
        pr.next = node.next;
        return head;
    }

    //快指针和慢指针
    /*
    执行用时 :
        0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗 :
        38 MB, 在所有 Java 提交中击败了5.43%的用户
     */
    public static ListNode removeNthFromEnd2(ListNode head,int n){
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        // [1,2,3,4,5]     倒数第二个
        //  0 1 2 3 4      size = 5, index = 3 删掉的get(3)
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(list.get(0));
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        removeNthFromEnd(node,1);
    }
}
