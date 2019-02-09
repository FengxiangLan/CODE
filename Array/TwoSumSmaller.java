public class TwoSumSmaller {
	public int smallerPairs(int[] array, int target) {
		int res = 0;
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] < target) {
				res += (right - left);
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}