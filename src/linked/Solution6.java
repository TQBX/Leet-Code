package linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 浅拷贝只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。但深拷贝会另外创造一个一模一样的对象，新对象跟原对象不共享内存，修改新对象不会改到原对象。
 * <p>
 * 作者：z1m
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * created by Summer-day
 */
public class Solution6 {
	
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		//复制结点值
		Node cur = head;
		//创建HashMap集合
		Map<Node, Node> map = new HashMap<>();
		while(cur != null) {
			map.put(cur, new Node(cur.val));//顺序遍历，存储老结点和新结点(先存储新创建的结点值)
			cur = cur.next;
		}
		//复制结点指向
		cur = head;
		while(cur != null) {
			
			map.get(cur).next = map.get(cur.next);//新结点next指向同旧结点的next指向
			map.get(cur).random = map.get(cur.random);//新结点random指向同旧结点的random指向
			cur = cur.next;
		}
		
		return map.get(head);
	}
}
