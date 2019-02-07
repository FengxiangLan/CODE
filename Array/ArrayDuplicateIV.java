public class ArrayDuplicateIV {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}

		int slow = -1;
		for (int fast = 0; fast < array.length; fast++) {
			if (slow == -1 || array[fast] != array[slow]) {
				array[++slow] = array[fast];
			} else {
				while (fast < array.length - 1 && array[fast + 1] = array[slow]) {
					fast++;
				}
				slow--;
			}
		}

		return Arrays.copyOf(array, slow + 1);
	}
}