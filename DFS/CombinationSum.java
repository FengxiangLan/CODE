public class CombinationSum {
	public List<List<Integer> combinationSum(int[] candidates, int target) {
		// 1. what does it store on each level ? 
		// 		- target / min(can)
	    // 2. how many different states should we try to put on this level ?
	    // 		- put in the number after itself
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    Arrays.sort(candidates);
	    if (candidates == null || candidates.length == 0 || candidates[0] > target) {
	    	return res;
	    }

	    List<Integer> path = new ArrayList<>();
	    helper(candidates, 0, 0, path, target, res);
	    return res;
	}

	private void helper(int[] candidates, int index, int sum, List<Integer> path, int target, List<List<Integer> res) {
		if (sum > target) {
			return;
		}

		if (sum == target) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				return;
			}

			sum += candidates[i];
			if (sum > target) {
				return;
			}

			path.add(candidates[i]);
			helper(candidates, index + 1, sum, path, target, res);
			path.remove(path.size() - 1);
			sum -= candidates[i];
		}
	}
}