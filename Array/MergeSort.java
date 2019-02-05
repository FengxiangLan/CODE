public class MergeSort {
	public int[] mergeSort(int[] array) {
		if (array == null) {
			return array;
		}

		int[] help = new int[array.length];
		helper(array, 0, array.length, help);
		return array;
	}

	private void helper(int[] array, int left, int riggt, int[] helper) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;
		helper(array, left, mid, helper);
		helper(array, mid + 1, right, helper);
		merge(array, left, mid, right, help);
	}

	private void merge(int[] array, int left, int mid, int right, int[] help) {
		for (int i = left; i <= right; i++) {
			help[i] = array[i];
		}

		int leftStart = left;
		int rightStart = mid + 1;

		while (leftStart <= mid && rightStart <= right) {
			if (help[leftStart] <= help[rightStart]) {
				array[left++] = help[leftStart++];
			} else {
				array[left++] = help[rightStart++];
			}
		}

		while (leftStart <= mid) {
			array[left++] = help[leftStart++];
		}

	}
}