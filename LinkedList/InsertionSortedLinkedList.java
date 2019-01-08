public class InsertionSortedLinkedList {
	public ListNode insertionSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummpyHead = new ListNode(0);
		dummpyHead.next = head;
		ListNode cur = head.next;
		ListNode prev = null;
		ListNode temp = head;
		while (cur != null) {
			prev = dummpyHead;
			while (prev.next != cur && prev.next.value <= cur.value) {
				prev = prev.next;
			}

			if (prev.next != cur) {
				temp.next = cur.next;
				cur.next = prev.next;
				prev.next = cur;
				cur = temp.next;
			}else {
				cur = cur.next;
				temp = temp.next;
			}
		}
		return dummpyHead.next;
	}
}