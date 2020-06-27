package linked;

/**
 * created by Summer-day
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Solution3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //建立哨兵节点
        ListNode res = new ListNode(-1);
        //指针
        ListNode l3 = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        l3.next = (l1 == null) ? l2 : l1;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.generateLinkedListNode(1, 2, 4);
        ListNode l2 = ListNodeUtils.generateLinkedListNode(1, 3, 4);
        Solution3 s = new Solution3();
        ListNode node = s.mergeTwoLists(l1, l2);
        ListNodeUtils.showListNode(node);
    }
}
