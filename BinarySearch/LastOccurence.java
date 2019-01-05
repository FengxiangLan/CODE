public class LastOccurence {
	// Given a target integer T and an integer array A sorted in ascending order, 
	// find the index of the last occurrence of T in A or return -1 if there is no 
	// such index

	// Assumption: There can be duplicate elements in the array

	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				left = mid;
			}
			else if (array[mid] < target){
				left = mid + 1;;
			}
			else {
				right = mid - 1;
			}
		}

		if (array[right] == target) {
			return right;
		}
		else if (array[left] == target) {
			return left;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		int target = 2;
		LastOccurence solution = new LastOccurence();
		int index = solution.search(array, target);
		System.out.println(index);
	}
}