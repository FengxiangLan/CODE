public class MergeSortLinkedList {
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		LisNode mid = findMiddle(head);
		ListNode midNext = mid.next;
		midNext = null;

		ListNode left = mergeSort(head);
		ListNode right = mergeSort(midNext);

		ListNode sortedList = combine(left, right);
		return sortedList;
	}

	private LisNode findMiddle(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private LisNode combine(ListNode left, ListNode) {
		ListNode dummy = new LisNode(0);
		ListNode cur = dummy;
		while (left != null && right != null) {
			if (left.value <= right.value) {
				cur.next = left;
				left = left.next;
			}else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}

		if (left != null) {
			cur.next = left;
		}
		else {
			cur.next = right;
		}

		return dummy.next;
	}
}