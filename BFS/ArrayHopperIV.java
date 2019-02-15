public class ArrayHopperIV {
	public int minJump(int[] array, int index) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[array.length];
		queue.offer(index);
		visited[index] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (cur == array.length - 1) {
					return cnt;
				}

				for (int j = 1; j <= array[cur]; j++) {
					if (cur + j < array.length && !visited[cur + j]) {
						queue.offer(cur + j);
						visited[cur + j] = true;
					}

					if (cur - j >= 0 && !visited[cur - j]) {
						queue.offer(cur - j);
						visited[cur - j] = true;
					}
				}
			}
			cnt++;
		}

		return -1;
	}
}