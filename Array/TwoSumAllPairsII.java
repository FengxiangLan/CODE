public class TwoSumAllPairsII {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : array) {
			Integer cnt = map.get(num);
			if (num * 2 == target && cnt != null && cnt == 1) {
				res.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				res.add(Arrays.asList(target - num, num));
			}

			if (cnt == null) {
				map.put(num, 1);
			} else {
				map.put(num, cnt + 1);
			}
		}
		return res;
	}
}