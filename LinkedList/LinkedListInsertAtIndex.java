public class LinkedListInsertAtIndex {
	public ListNode insert(ListNode head, int index, int value) {
		ListNode newNode = new ListNode(value);
		if (head == null && index > 0) {
			return head;
		}

		if (head == null && index == 0) {
			head = newNode;
			return head;
		}

		if (index == 0) {
			newNode.next = head;
			return newNode;
		}

		ListNode prev = null;
		ListNode cur = head;
		
		int i = 0;
		while (i < index) {
			prev = cur;
			if (prev == null) {
				break;
			}
			cur = cur.next;
			i++;
		}

		if (prev != null){
			newNode.next = cur;
			prev.next = newNode;
		}

		return head;
	}
}