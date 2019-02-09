public class ThreeSumThreeArrays {
	public boolean exist(int[] a, int[] b, int[] c, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				set.add(a[i] + b[j]);
			}
		}

		for (int i = 0; i< c.length; i++) {
			if (set.contains(target - c[i])) {
				return true;
			}
		}

		return false;
	}
}