public class NumberOfPairsDiffToTarget {
	public int pairs(int[] array, int target) {
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (Math.abs(array[i] - array[j]) == Math.abs(target)) {
					res++;
				}
			}
		}
		return res;
	}
}