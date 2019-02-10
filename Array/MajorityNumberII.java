public class MajorityNumberII {
	public List<Integer> majority(int[] array) {
		List<Integer> res = new ArrayList<>();
		if (array == null || array.length == 0) {
			return res;
		}

		int len = array.length / 3;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer cnt = map.get(array[i]);
			if (cnt == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], cnt + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > len) {
				res.add(entry.getKey());
			}
		}

		return res;
	}
}