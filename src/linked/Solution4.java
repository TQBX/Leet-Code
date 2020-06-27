package linked;

/**
 * created by Summer-day
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution4 {

    public ListNode reverseList(ListNode head) {
        //建立哨兵节点
        ListNode dummyNode = new ListNode(-1);
        //建立临时节点
        ListNode curr = head;
        //保存下一个
        ListNode next;
        while (curr != null) {
            //先用next保存curr的下一个
            next = curr.next;
            //dummyNode->curr->null;
            curr.next = dummyNode.next;
            dummyNode.next = curr;
            //curr向后移
            curr = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeUtils.generateLinkedListNode(1, 2, 3, 4, 5);
        Solution4 s = new Solution4();
        ListNode newNode = s.reverseList(node);
        ListNodeUtils.showListNode(newNode);
    }
}
