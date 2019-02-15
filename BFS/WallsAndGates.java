public class WallsAndGates {
	public int[][] wallsAndGates(int[][] rooms) {
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					queue.offer(new Pair(i, j));
				}
			}
		}
		int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int newX = x + dirs[i][0];
				int newY = y + dirs[i][1];
				if (newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms[0].length || rooms[newX][newY] < rooms[x][y] + 1) {
					continue;
				}
				rooms[newX][newY] = rooms[x][y] + 1;
				queue.offer(new Pair(newX, newY));
			}
		}

		return rooms;
	}

	static class Pair {
		public int x;
		public int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}