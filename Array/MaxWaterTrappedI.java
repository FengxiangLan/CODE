public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		int res = 0;
		int left = 0;
		int right = array.length - 1;
		int lmax = array[left];
		int rmax = array[right];
		while (left < right) {
			lmax = Math.max(lmax, array[left]);
			rmax = Math.max(rmax, array[right]);
			if (lmax < rmax) {
				res += (lmax - array[left]);
				left++;
			} else {
				res += (rmax - array[right]);
				right--;
			}
		}
		return res;
	}
}
