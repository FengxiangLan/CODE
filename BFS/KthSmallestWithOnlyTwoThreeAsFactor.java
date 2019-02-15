public class KthSmallestWithOnlyTwoThreeAsFactor {
	public int kth(int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer one, Integer two) {
				if (one == two) {
					return 0;
				}

				return one < two ? -1 : 1;
			}
		});
		Set<Integer> visited = new HashSet<>();
		minHeap.offer(1);
		visited.add(1);
		while (k > 1) {
			Integer cur = minHeap.poll();
			if (visited.add(cur * 2)) {
				minHeap.offer(cur * 2);
			}

			if (visited.add(cur * 3)) {
				minHeap.offer(cur * 3);
			}
			k--;
		}

		return minHeap.peek();
	}
}