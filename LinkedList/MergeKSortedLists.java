public class MergeKSortedLists {
	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (ListNode node : listOfLists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}

		while (!minHeap.isEmpty()) {
			cur.next = minHeap.poll();
			if (cur.next.next != null) {
				minHeap.offer(cur.next.next);
			}
			cur = cur.next;
		}
		return dummy.next;
	}

	static class MyComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode node1, ListNode node2) {
			if (node1.value == node2.value) {
				return 0;
			}

			return node1.value < node2.value ? -1 : 1;
		}
	}
}