public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		// k level
		// each level means choose one element from 1 to n (without depulicate)
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 0) {
			return res;
		}

		List<Integer> path = new ArrayList<Integer>();
		helper(n, 1, 0, k, path, res);
		return res;
	}

	private void helper(int n, int t, int cnt, int k, List<Integer> path, List<List<Integer>> res) {
		if (cnt == k) {
			res.add(new ArrayList<Integer>(path));
		}

		for (int i = t; i <= n; i++) {
			path.add(i);
			helper(n, i + 1, cnt + 1, k, path, res);
			path.remove(path.size() - 1);
		}
	}

	// Time-cost = n + n - 1 + n - 2 + ... + 1 = O(n^2)
	// Space-cost = O(k)
}