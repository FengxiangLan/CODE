public class TwoSumSmaller {
	public int smallerPairs(int[] array, int target) {
		int res = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] + array[j] < target) {
					res++;
				} else {
					break;
				}
			}
		}

		return res;
	}
}