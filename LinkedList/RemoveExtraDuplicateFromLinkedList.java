public class RemoveExtraDuplicateFromLinkedList {
	public ListNode removeDup(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummpyHead = new ListNode(0);
		dummpyHead.next = head;
		ListNode first = dummpyHead;
		ListNode cur = head;

		while (cur != null) {
			while (cur.next != null && first.next.value == cur.next.value) {
				cur = cur.next;
			}

			if (first.next == cur) {
				first = first.next;
			}
			else {
				first.next = cur.next;
			}

			cur = cur.next;
		}

		return dummpyHead.next;
	}
}