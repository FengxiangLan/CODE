public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}

		sort(array, 0, array.length - 1);
		return array;
	}

	private void sort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		int pIndex = partition(array, left, right);
		// System.out.println(pIndex);
		sort(array, left, pIndex);
		sort(array, pIndex + 1, right);

	}

	private int partition(int[] array, int left, int right) {
		// can not choose right or left as pivot
		int pivotIndex = left + (int)(Math.random() * (right - left + 1));
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, right);
		int i = left;
		int j = right - 1;
		while (i <= j) {
			if (array[i] < pivot) {
				i++;
			} else if (array[j] >= pivot) {
				j--;
			} else {
				swap(array, i++, j--);
			}
		}

		swap(array, i, right);
		return i;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		 int[] array = {3,5,1,2,4,8};
		 QuickSort solution = new QuickSort();
		 solution.quickSort(array);
	}
}