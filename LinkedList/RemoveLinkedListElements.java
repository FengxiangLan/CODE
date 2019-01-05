public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}

		ListNode dummpyHead = new ListNode(0);
		dummpyHead.next = head;
		ListNode cur = dummpyHead;
		while (cur.next != null) {
			if (cur.next.value == val) {
				ListNode next = cur.next;
				cur.next = next.next;
			}
			else {
				cur = cur.next
			}
		}

		return dummpyHead.next;
	}
}