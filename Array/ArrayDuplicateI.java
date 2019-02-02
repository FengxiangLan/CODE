public class ArrayDuplicateI {
	public int[] dedup(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int slow = 1;
		for (int fast = 1; fast < array.length; fast++) {
			if (array[fast] != array[slow - 1]) {
				array[slow++] = array[fast];
			} else {
				continue;
			}
		}

		return Arrays.copyOf(array, slow);
	}
}