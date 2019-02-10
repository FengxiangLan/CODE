public class SmallestRange {
	public int[] smallestRange(int[][] arrays) {
		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new Comparator<Entry>(){
			@Override
			public int compare(Entry e1, Entry e2) {
				if (e1.value == e2.value) {
					return 0;
				}

				return e1.value < e2.value ? -1 : 1;
			}
		});

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arrays.length; i++) {
			minHeap.offer(new Entry(i, 0, arrays[i][0]));
			max = Math.max(max, arrays[i][0]);
		}

		int range = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		
		while (minHeap.size() == arrays.length) {
			Entry temp = minHeap.poll();
			if (max - temp.value < range) {
				range = max - temp.value;
				start = temp.value;
				end = max;
			}

			if (temp.y + 1 < arrays[temp.x].length) {
				temp.y++;
				temp.value = arrays[temp.x][temp.y];
				minHeap.offer(temp);
				if (temp.value > max) {
					max = temp.value;
				}
			}
		}

		return new int[] {start, end};
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