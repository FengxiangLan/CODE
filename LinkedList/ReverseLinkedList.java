public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode next = null;
		ListNode cur = head;

		while (cur != null) {
			next = cur.next;
			prev = cur;
			cur = next;
		}

		return prev;
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}