public class TwoSum {
	public boolean existSum(int[] array, int target) {
		if (array == null || array.length == 0) {
			return false;
		}

		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			if (set.contains(target - num)) {
				return true;
			}

			set.add(num);
		}

		return false;
	}
}