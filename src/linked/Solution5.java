package linked;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * created by Summer-day
 */
public class Solution5 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        //跳出循环的条件:下一个为空或值不相等,排除其一
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
        return head;
    }


}
