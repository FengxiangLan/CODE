public class LargestContainer {
	public int largest(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max, Math.min(array[left], array[right]) * (right - left));
			if (array[left] < array[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}