public class RemoveNthNodeFromEndofLinkedList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || (head.next == null && n >= 0) || n < 0) {
			return head;
		}

		if (n == 0) {
			return head.next;
		}

		ListNode reverseHead = reverse(head);
		System.out.println()
		ListNode prev = null;
		ListNode cur = reverseHead;
		if (n == 1) {
			return reverse(reverseHead.next);
		}
		int i = 1;
		while (i < n) {
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

		return reverse(reverseHead);
		
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}