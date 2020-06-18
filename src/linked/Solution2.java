package linked;

/**
 * @author Summerday
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution2 {

    public int[] reversePrint(ListNode head) {

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        int[] arr = new int[len];
        curr = head;
        int index = len - 1;
        while (curr != null) {
            arr[index--] = curr.val;
            curr = curr.next;
        }
        return arr;
    }

    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode next = null;
        int len = 0;
        while (temp != null) {
            next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
            temp = next;
            len++;
        }
        head = dummy.next;
        int[] arr = new int[len];
        int index = 0;
        temp = head;
        while (temp != null) {
            arr[index++] = temp.val;
            temp = temp.next;
        }
        return arr;

    }

    public static void main(String[] args) {
        //ListNode node0 = new ListNode(1);
        //ListNode node1 = new ListNode(2);
        //ListNode node2 = new ListNode(3);
        //node0.next = node1;
        //node1.next = node2;
        //ListNodeUtils.showListNode(node0);

        ListNode node = ListNodeUtils.generateLinkedListNode(1, 2, 3, 4, 5);
        ListNodeUtils.showListNode(node);
        Solution2 s = new Solution2();
        int[] arr = s.reversePrint(node);
        for (int i : arr) {
            System.out.println(i);

        }

    }

}
