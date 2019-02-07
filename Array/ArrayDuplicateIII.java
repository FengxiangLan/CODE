public class ArrayDuplicateIII {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}

		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			int begin = fast;
			while (fast < array.length && array[fast] == array[begin]) {
				fast++;
			}

			if (fast - beigin == 1) {
				array[slow++] = array[begin];
			}
		}

		return Arrays.copyOf(array, slow);
	}
}