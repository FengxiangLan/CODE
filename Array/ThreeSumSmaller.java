public class ThreeSumSmaller {
	public int threeSumSmaller(int[] num, int target) {
		if (num == null || num.length < 3) {
			return 0;
		}

		Arrays.sort(num);
		int res = 0;
		for (int i = 0; i < num.length; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				if (num[i] + num[left] + num[right] < target) {
					res += (right - left);
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}