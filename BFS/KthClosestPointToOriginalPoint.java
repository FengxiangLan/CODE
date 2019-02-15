public class KthClosestPointToOriginalPoint {
	public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> one, List<Integer> two) {
				long d1 = distance(one, a, b, c);
				long d2 = distance(two, a, b, c);
				if (d1 == d2) {
					return 0;
				}
				return d1 < d2 ? -1 : 1;
			}
		});

		Set<List<Integer>> visited = new HashSet<>();
		List<Integer> cur = Arrays.asList(0, 0, 0);
		minHeap.offer(cur);
		visited.add(cur);
		while (k > 0) {
			cur = minHeap.poll();

			List<Integer> temp = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if (temp.get(0) < a.length && visited.add(temp)) {
				minHeap.offer(temp);
			}

			temp = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if (temp.get(1) < b.length && visited.add(temp)) {
				minHeap.offer(temp);
			}

			temp = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if (temp.get(2) < c.length && visited.add(temp)) {
				minHeap.offer(temp);
			}

			k--;
		}

		cur.set(0, a[cur.get(0)]);
		cur.set(1, b[cur.get(1)]);
		cur.set(2, c[cur.get(2)]);
		return cur;
	}

	private long distance(List<Integer> indexs, int[] a, int[] b, int[] c) {
		long dis = 0;
		dis += a[indexs.get(0)] * a[indexs.get(0)];
		dis += b[indexs.get(1)] * b[indexs.get(1)];
		dis += c[indexs.get(2)] * c[indexs.get(2)];
		return dis;
	}
}
