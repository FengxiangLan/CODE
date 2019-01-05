public class FindLocalMinimum {
	// Given an unsorted integer array, return any of the local minimum's index.
	public int localMinimum(int[] array) {
		return helper(array, 0, array.length - 1);
	} 

	private int helper(int[] array, int left, int right) {
		int mid = left + (right - left) / 2;
		if ((mid == 0 || (array[mid - 1] > array[mid])) && (mid == array.length - 1 || array[mid + 1] > array[mid])) {
			System.out.println(mid);
			System.out.println(mid == 0 || array[mid - 1] > array[mid] && (mid == array.length - 1) || array[mid + 1] > array[mid]);
			return mid;
		}
		else if (mid > 0 && array[mid - 1] < array[mid]) {
			return helper(array, left, mid - 1);
		}
		return helper(array, mid + 1, right);
	}

	public static void main(String[] args) {
		int[] array = {23, 8, 15, 22, 33};
		FindLocalMinimum solution = new FindLocalMinimum();
		int index = solution.localMinimum(array);
	}
}