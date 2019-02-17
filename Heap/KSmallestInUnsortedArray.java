public class KSmallestInUnsortedArray {
	// keep min heap
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(array.length, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}

				return o1 < o2 ? -1 : 1;
			}
		});

		for (int i = 0; i < array.length; i++) {
			minHeap.offer(array[i]);
		}
		// O(n)

		k = k > array.length ? array.length : k;
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = minHeap.peek();
      		minHeap.poll();
		}
		// O(klogn)

		return res;
	}
	// O(n + klogn)

	// keep max heap
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}

				return o1 > o2 ? -1 : 1;
			}
		});

		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				maxHeap.offer(array[i]); // O(k)
			} else if (array[i] < array[k]) {
				minHeap.poll();
				minHeap.offer(array[i]); // O((n - k)logk)
			}
		}

		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i++) {
			res[i] = minHeap.peek();
      		minHeap.poll();
		}
		return res;
		// O(k + (n-k)logk)
	}
}