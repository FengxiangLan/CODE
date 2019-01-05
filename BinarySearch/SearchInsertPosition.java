public class SearchInsertPosition {
	// Given a sorted array and a target value, return the index where it would be 
	// if it were inserted in order.

	// Assumption: If there are multiple elements with value same as target, 
	// we should insert the target before the first existing element.

	public int search(int[] input, int target) {
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (input[mid] >= target) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return ((left == input.length - 1) && (input[left] < target)) ? left + 1: left;
	}
}