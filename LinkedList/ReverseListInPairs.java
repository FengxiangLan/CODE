public class ReverseListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur = dummyHead;
		while (cur.next != null && cur.next.next != null) {
			ListNode next = cur.next.next;
			cur.next.next = cur.next.next.next;
			next.next = cur.next;
			cur.next = next;
			cur = cur.next.next;
		}

		return dummyHead.next;
	}

	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = head.next;
		head.next = reverseInPairs(head.next.next);
		newHead.next = head;
		return newHead;
	}
}