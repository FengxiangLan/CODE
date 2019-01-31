public class FactorsCombinations {
	public List<List<Integer>> combinations(int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		helper(target, 2, 1, path, res);
		return res;
	}

	private void helper(int target, int factor, int product, List<Integer> path, List<List<Integer>> res) {
		if (factor > target || product > target) {
			return;
		}

		if (product == target) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = factor; i <= n / 2; i++) {
			if (i * product > n) {
				break;
			}

			if (target % i == 0) {
				path.add(i);
				helper(target, i, i * product, path, res);
				path.remove(path.size() - 1);
			}
		}
	}
}