public class SelectionSort {
	public int[] selectSort(int[] array) {
		// Time-cost = O(n^2)
		// Space-cost = O(1)
		if (array == null || array.length <= 1) {
			return array;
		}

		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++){
				if (array[j] < array[min]) {
					min = j;
				}
			}

			int tmp = array[i];
			array[i] = array[min];
			array[min] = tmp;
		}

		return array;
	}
}