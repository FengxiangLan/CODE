public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		int diff = Integer.MAX_VALUE;
		if (num == null || num.length <= 2) {
			return diff;
		}
		
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				if (num[i] + num[left] + num[right] == target) {
					return 0;
				} else if (num[i] + num[left] + num[right] < target){
					if (Math.abs(num[i] + num[left] + num[right] - target) < diff) {
						diff = Math.abs(num[i] + num[left] + num[right] - target);
					}
					left++;
					while (left < right && num[left] == num[left - 1]) {
						left++;
					}
				} else {
					if (Math.abs(num[i] + num[left] + num[right] - target) < diff) {
						diff = Math.abs(num[i] + num[left] + num[right] - target);
					}
					right--;
				}
			}
		}
		return diff;
	}
}