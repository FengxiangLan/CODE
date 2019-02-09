public class MergeKSortedArray {
	public int[] merge(int[][] arrayOfArrays) {
		int k = arrayOfArrays.length;
		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
		int length = 0;
		for (int i = 0; i < k; i++) {
			int[] array = arrayOfArrays[i];
			length += array.length;
			if (array.length != 0) {
				minHeap.offer(new Entry(i, 0, array[0]));
			}
		}

		int[] res = new int[length];
		int cur = 0;
		while (!minHeap.isEmpty()) {
			Entry temp = minHeap.poll();
			res[cur++] = temp.value;
			if (temp.y + 1 < arrayOfArrays[temp.x].length) {
				temp.y++;
				temp.value = arrayOfArrays[temp.x][temp.y];
				minHeap.offer(temp);
			}
		}
		return res;
	}

	static class MyComparator implements Comparator<Entry> {
		@Override
		public int compare(Entry e1, Entry e2) {
			if (e1.value == e2.value) {
				return 0;
			}

			return e1.value < e2.value ? -1 : 1;
		}
	}

	static class Entry {
		int x;
		int y;
		int value;
		Entry(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
}