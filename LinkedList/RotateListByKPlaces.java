public class RotateListByKPlaces {
	public ListNode rotateKplace(ListNode head, int n) {
		// Write your solution here
		if (head == null || head.next == null || n == 0) {
			return head;
		}

		int len = 1;
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
			len++;
		}

		cur.next = head;

		int m = len - n % len;
		for (int i = 0; i < m; i++) {
			cur = cur.next;
		}

		ListNode newHead = cur.next;
		cur.next = null;

		return newHead;
	}
}