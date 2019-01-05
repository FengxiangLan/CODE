public class ClassicalBinarySearch {
	// Given a target integer T and an integer array A sorted in ascending order, 
	// find the index i such that A[i] == T or return -1 if there is no such index.

	// Assumptions
	// There can be duplicate elements in the array, and you can return any of the 
	// indices i such that A[i] == T.


	// Examples
	// A = {1, 2, 3, 4, 5}, T = 3, return 2
	// A = {1, 2, 3, 4, 5}, T = 6, return -1
	// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

	// Corner Cases
	// What if A is null or A is of zero length? We should return -1 in this case.

	public int search(int[] array, int target) {
		// corner case
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			// keep two element, end loop only when left == right;
			// so we should judge the remained element
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			else if (array[mid] < target) {
				left = mid + 1; // because after we left two element, 
							    // the mid index is always equal to left index
							    // if we do not let left = mid + 1, it will be caught
							    // in a cycle.
			}
			else {
				right = mid - 1; 
				// can be right = mid; then the return statment can be array[right] == target;
			}
		}

		return array[left] == target ? target : -1;
	}

	// Time Cost = O(n)
	// Space-Cost = O(1)
}