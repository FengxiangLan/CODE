public class RemoveDuplicatesFromSortedList {
	public ListNode remove(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode next = null;
		while (cur.next != null) {
			if (cur.value == cur.next.value) {
				next = cur.next.next;
				cur.next = null;
				cur.next = next;
			}
			else {
				cur = cur.next;
			}
		}

		return head;
	}
}