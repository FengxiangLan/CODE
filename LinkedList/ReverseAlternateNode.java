public class ReverseAlternateNode {
	public ListNode reverseAlternate(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode even = head.next;
		head.next = head.next.next;
		head = head.next;
		even.next = null;

		while (head != null && head.next != null) {
			ListNode temp = head.next.next;
			head.next.next = even;
			even = head.next;
			head.next = temp;

			if (temp != null) {
				head = temp;
			}
		}

		head.next = even;

		return dummy.next;
	}
}