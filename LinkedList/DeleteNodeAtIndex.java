public class DeleteNodeAtIndex {
	public ListNode deleteNode(ListNode head, int index) {
		if (head == null || index < 0) {
			return head;
		}

		if (index == 0) {
			return head.next;
		}

		ListNode prev = null;
		ListNode cur = head;
		int i = 0;
		while (i < index) {
			prev = cur;
			if (prev == null) {
				break;
			}
			cur = cur.next;
			i++;
		}

		if (cur != null) {
			prev.next = cur.next;
			cur.next = null;
		}	
		return head;
	}
}