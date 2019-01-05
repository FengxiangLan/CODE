public class DeleteNodesAtIndices {
	// Given a linked list and an sorted array of integers as the indices 
	// in the list. Delete all the nodes at the indices in the original list.
	public ListNode deleteNodes(ListNode head, int[] indices) {
		if (head == null) {
			return head;
		}

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode cur = head;
		int index = 0;
		for (int num : indices) {
			while (cur != null && index != num) {
				prev = cur;
				cur = cur.next;
				index++;
			}

			if (cur == null) {
				break;
			}

			if (index == num) {
				ListNode next = cur.next;
				prev.next = next;
				cur = prev.next;
			}
			index++;
		}

		return dummyHead.next;
	}
}