public class SearchInShiftedSortedArrayI {
	// Given a target integer T and an integer array A, 
	// A is sorted in ascending order first, then shifted 
	// by an arbitrary number of positions.

	// Assumption: There are no duplicate elements in the array;
	
	// if (mid, right] increasing
	// 		- target < right 
	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} 
			
			if (array[mid] < array[right]) {
				if (target > array[mid] && target <= array[right]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			else {
				if (target >= array[left] && target < array[mid]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
		}

		return -1;
	}
}