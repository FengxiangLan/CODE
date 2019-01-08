public class CheckIfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode mid = findMiddle(head);
		ListNode leftPart = head;
		ListNode rightPart = reverse(mid.next);
		mid.next = null;

		boolean res = compare(leftPart, rightPart);
		return res;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode next = null;
		ListNode cur = head;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private boolean compare(ListNode one, ListNode two) {
		ListNode p = one;
		ListNode q = two;

		while (p != null && q != null) {
			if (p.value != q.value) {
				return  false;
			}

			p = p.next;
			q = q.next;
		}

		return true;
	}
}