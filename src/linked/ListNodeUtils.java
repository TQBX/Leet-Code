package linked;

/**
 * @author Summerday
 */
public class ListNodeUtils {

    private ListNodeUtils(){

    }

    public static void showListNode(ListNode node){
        ListNode curr = node;
        while(curr!=null){
            if(curr.next != null){
                System.out.print(curr.val+"->");
            }else {
                System.out.print(curr.val);
            }
            curr = curr.next;
        }
    }

    public static ListNode generateLinkedListNode(ListNode head){
        return head;
    }
    public static ListNode generateLinkedListNode(int... arr){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i : arr) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }




}
