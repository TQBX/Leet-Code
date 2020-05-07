package linked.twoNumAdd;

/**
 * @author Summerday
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //建立哨兵节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //代表进位(只有0或1)
        int carry = 0;
        //两个都为null退出循环
        while (p != null || q != null) {
            // 如果为空,则认为是0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            //进位+各取数的和
            int sum = carry + x + y;
            //更新进位
            carry = sum / 10;
            //赋值,遍历
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //到最后进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void list(ListNode node){
        ListNode curr = node;
        while(curr!=null){
            if(curr.next!=null) {
                System.out.print(curr.val + "-->");
            }else {
                System.out.print(curr.val);
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(8);

        node1.next = node2;

        ListNode node4 = new ListNode(1);

        list(node1);
        System.out.println();
        list(node4);

        ListNode node = addTwoNumbers(node1, node4);

        System.out.println();
        list(node);
    }
}
