public class FirstOccurrence {
	// Given a target integer T and an integer array A sorted in ascending order, 
	// find the index of the first occurrence of T in A or return -1 if there is 
	// no such index.

	// Assumption: There can be duplicate elements in the array

	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}

		return array[left] == target ? left : -1;
	}
}