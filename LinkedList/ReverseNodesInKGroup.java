public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		for (int i = 0; i < k; i++) {
			if (cur == null) {
				return head;
			}
			cur = cur.next;
		}

		ListNode newHead = reverse(head, cur);
		head.next = reverseKGroup(cur, k);
		return newHead;
	}

	private ListNode reverse(ListNode head, ListNode cur) {
		ListNode prev = null;
		while (head != cur) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}