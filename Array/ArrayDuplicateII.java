public class ArrayDuplicateII {
	public int[] dedup(int[] array) {
		if (array.length <= 2) {
			return array;
		}

		int slow = 2;
		for (int fast = 2; fast < array.length; fast++) {
			if (array[fast] != array[slow - 2]) {
				array[slow++] = array[fast];
			} else {
				continue;
			}
		}

		return Arrays.sort(array, slow);
	}
}