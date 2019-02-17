public class KSortedArray {
	public int[] ksort(int[] array, int k) {
		if (array.length == 0) {
			return array;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}

				return o1 < o2 ? -1 : 1;
			}
		});

		int index = 0;
		for (int i = 0; i < array.length; i++){
			if (i < k + 1) {
				minHeap.offer(array[i]);
			} else {
				array[index++] = minHeap.peek();
				minHeap.poll();
				minHeap.offer(array[i]);
			}
		}

		while (!minHeap.isEmpty()) {
			array[index++] = minHeap.peek();
			minHeap.poll();
		}
		return array;
	}
}