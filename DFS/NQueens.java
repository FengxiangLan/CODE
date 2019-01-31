public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		// n level 行
		// each level 放在那一列
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 0) {
			return res;
		}
		List<Integer> path = new ArrayList<Integer>();
		helper(n, path, res);
		return res;
	}

	private void helper(int n, List<Integer> path, List<List<Integer>> res) {
		if (path.size() == n) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (valid(path, i)) {
				path.add(i);
				helper(n, path, res);
				path.remove(path.size() - 1);
			}		
		}
	}

	private boolean valid(List<Integer> path, int column) {
		int row = path.size();
		for (int i = 0; i < row; i++) {
			if (path.get(i) == column || Math.abs(path.get(i) - column) == row - i) {
				return false;
			}
		}
		return true;
	}
}