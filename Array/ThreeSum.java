public class ThreeSum {
	public List<List<Integer>> allTriples(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				if (array[i] + array[left] + array[right] == target) {
					res.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					while (left < right && array[left] == array[left - 1]) {
						left++;
					}
				} else if (array[i] + array[left] + array[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}