public class TwoSumTwoArray {
	public boolean existSum(int[] a, int[] b, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int i = 0; i < b.length; i++) {
			if (set.contains(target - b[i])) {
				return true;
			}
		}

		return false;
	}
}