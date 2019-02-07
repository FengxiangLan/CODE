public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int i = 0;
		int j = 0;
		int k = array.length - 1;
		// all letters to the left-hand side of i are all '-1's
		// all letters in [i, j) are all '0's
		// all letters to the right-hand side of k are all '1's 
		// xxxxxx i yyyyyyy j _______ k zzzzzz 
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i++, j++);
			} else if (array[j] == 0) {
				j++;
			} else {
				swap(array, j, k--);
			}
		}
		return array;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}