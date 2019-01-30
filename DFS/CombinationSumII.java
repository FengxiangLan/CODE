public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}

		Arrays.sort(num);
		if (num[0] > target) {
			return res;
		}

		List<Integer> path = new ArrayList<Integer>();
		helper(num, target, 0, path, res);
		return res;
	}

	private void helper(int[] num, int target, int index, List<Integer> path, List<List<Integer>> res) {
		if (target < 0) {
			return;
		}
		else if (target == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		else {
			for (int i = index; i < num.length; i++) {
				path.add(num[i]);
				helper(num, target - num[i], i + 1, path, res);
				path.remove(path.size() - 1);
				while (i < num.length - 1 && num[i] == num[i + 1]) {
					i++;
				}
			}
		}
	}
}