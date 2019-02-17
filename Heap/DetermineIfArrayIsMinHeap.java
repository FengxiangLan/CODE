public class DetermineIfArrayIsMinHeap {
	public boolean isMinHeap(int[] array) {
		if (array == null || array.length == 0) {
			return true;
		}

		for (int i = 0; i <= array.length / 2 - 1; i++) {
			int leftChild = i * 2 + 1;
			int righChild = i * 2 + 2;
			if (array[leftChild] < array[i]) {
				return false;
			}

			if (righChild < array.length && array[righChild] < array[i]) {
				return false;
			}
		}
		return true;
	}
}