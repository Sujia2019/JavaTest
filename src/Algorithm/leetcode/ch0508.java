package Algorithm.leetcode;
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class ch0508 {

    //要注意链表的 指向
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //记录头指针
        ListNode res = new ListNode(0);
        //记录当前位置
        ListNode index = res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                index.next = l1;
                index = index.next;
                l1 = l1.next;
            }else{
                index.next = l2;
                index = index.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            index.next=l2;
        }else{
            index.next=l1;
        }
        //因为第一个是自己创建的，所以返回的应该是next
        return res.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = mergeTwoLists(l1,l2);

        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
