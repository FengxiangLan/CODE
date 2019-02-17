public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}

				return o1 < o2 ? -1 : 1;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				minHeap.offer(nums[i]);
			} else if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(nums[i]);
			}
		}

		return minHeap.peek();
	}
}
