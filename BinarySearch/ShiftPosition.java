public class ShiftPosition {
	// Given an integer array A, A is sorted in ascending order 
	// first then shifted by an arbitrary number of positions.
	// Find the index of the smallest number.

	// Assumptions: There are no duplicate elements in the array
	public int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == array[right]) {
				return right;
			}
			else if (array[mid] > array[right]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return -1;
	}
}