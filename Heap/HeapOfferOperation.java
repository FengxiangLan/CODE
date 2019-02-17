public class HeapOfferOperation {
	public int[] offerHeap(int[] array, int ele) {
		array[array.length - 1] = ele;
		if (array.length == 1) {
			return array;
		}
		percolateUp(array, array.length - 1);
		return array;
	}

	private void percolateUp(int[] array, int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(array, parentIndex, index);
			} else {
				break;
			}
			index = parentIndex;
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}