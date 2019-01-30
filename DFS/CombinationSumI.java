import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumI {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(candidates);

		helper(candidates, target, 0, path, res);
		return res;
	}

	private void helper(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> res) {
		if (index == candidates.length - 1) {
			if (target % candidates[index] == 0) {
				for (int i = 0; i < target / candidates[index]; i++) {
					path.add(candidates[index]);
				}
				//System.out.println(path);
				res.add(new ArrayList<Integer>(path));
				//System.out.println(res);
				for (int i = 0; i < target / candidates[index]; i++) {
					path.remove(path.size() - 1);
				}
			}
			return;
		}

		int max = target / candidates[index];
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < i; j++) {
				path.add(candidates[index]);
			}
			helper(candidates, target - i * candidates[index], index + 1, path, res);
			for (int j = 0; j < i; j++) {
				path.remove(path.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = {6,3,2,1};
		int target = 12;
		CombinationSumI solution = new CombinationSumI();
		solution.combinationSum(candidates, target);
	}
}