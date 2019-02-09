import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class TwoSumAllPairsI {
	public List<List<Integer>> allPairs(int[] array, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (array == null || array.length == 0) {
			return res;
		}

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {
				List<Integer> indexs = map.get(target - array[i]);
				for (int j = 0; j < indexs.size(); j++) {
					List<Integer> path = new ArrayList<>();
					path.add(indexs.get(j));
					path.add(i);
					res.add(path); 
				}
			}

			List<Integer> indexs = map.get(array[i]);
			if (indexs == null) {
				indexs = new ArrayList<Integer>();
			}
			indexs.add(i);
			map.put(array[i], indexs);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] array = {3,9,1,2,3};
		int target = 4;
		TwoSumAllPairsI solution = new TwoSumAllPairsI();
		List<List<Integer>> res = solution.allPairs(array, target);
		System.out.println(res);
	}
}