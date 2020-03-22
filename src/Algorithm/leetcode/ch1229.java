package Algorithm.leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class ch1229 {

    public ListNode creatList(int a,int b,int c){
        ListNode node = new ListNode(a);
        ListNode nodeb = new ListNode(b);
        ListNode nodec = new ListNode(c);
        node.next=nodeb;
        nodeb.next=nodec;
        return node;
    }

    public ListNode creatList(int[] a){
        ListNode node = null;
        for(int i=0;i<a.length;i++){
            if(node==null){
                node = new ListNode(a[i]);
            }else{
                ListNode cur = node;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = new ListNode(a[i]);
            }
        }
        return node;
    }
    public void printList(ListNode list){
        ListNode node = list;
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    //我的答案
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1=l1;
        ListNode n2=l2;
        ListNode nn = new ListNode(0);
        ListNode res = null;
        while (true){
            int addr=nn.val;
            if(n1!=null&&n2!=null){
                addr = n1.val+n2.val+nn.val;
            }else if(n2!=null){
                addr+=n2.val;
            }else if(n1!=null){
                addr+=n1.val;
            }else if(addr==0){
                break;
            }
            int jin = 0;
            if(addr/10>=1){
                jin=1;
            }
            addr=addr%10;

            if(res==null){
                res=new ListNode(addr);
            }else{
                ListNode cur = res;
                while (cur.next!=null){
                    cur=cur.next;
                }
                cur.next=new ListNode(addr);
            }
            nn.next=new ListNode(jin);
            nn=nn.next;

            if(n1!=null&&n2!=null){
                n1=n1.next;
                n2=n2.next;
            }else if(n2!=null){
                n2=n2.next;
            }else if(n1!=null){
                n1=n1.next;
            }else if(addr==0){
                break;
            }
        }
        return res;
    }

    //优化代码
    public ListNode resAdd(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(0);
        if(l1 == null){
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int num = l1.val +l2.val+listNode.val;

        l1 = l1.next;
        l2 = l2.next;
        if(l1 != null||l2!= null){
            listNode.next = addTwoNumbers(l1,l2);
        }
        if( num<10 ){
            listNode.val =num;
        }else {
            listNode.val =num - 10;
            listNode.next = addTwoNumbers(new ListNode(1),listNode.next);
        }

        return listNode;
    }

    public static void main(String[] args) {
        ch1229 test = new ch1229();
        ListNode list1 = test.creatList( new int[]{2,4,3});
        ListNode list2 = test.creatList( new int[]{5,6,8});
//        System.out.println(test.addTwoNumbers(list1,list2).val);
        test.printList(test.addTwoNumbers(list1,list2));

    }

}
