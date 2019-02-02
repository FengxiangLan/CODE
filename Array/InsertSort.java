public class InsertSort {
	// Time-cost = O(n^2)
	// Space-cost = O(1)
	public int[] sort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			} 
		}
		return array;
	}
}